package com.arshad.monolith.InventoryManagementSystem.serviceImpl;

import com.arshad.monolith.InventoryManagementSystem.beans.CustomerResponseModel;
import com.arshad.monolith.InventoryManagementSystem.beans.Invoice;
import com.arshad.monolith.InventoryManagementSystem.beans.InvoiceResponseModel;
import com.arshad.monolith.InventoryManagementSystem.beans.ProductResponseModel;
import com.arshad.monolith.InventoryManagementSystem.mapper.InvoiceMapper;
import com.arshad.monolith.InventoryManagementSystem.repo.InvoiceJPARepository;
import com.arshad.monolith.InventoryManagementSystem.services.CustomerService;
import com.arshad.monolith.InventoryManagementSystem.services.InvoiceService;
import com.arshad.monolith.InventoryManagementSystem.services.ProductService;
import com.arshad.monolith.InventoryManagementSystem.utils.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("invoiceServiceDbImpl")
public class InvoiceServiceDbImpl implements InvoiceService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    @Autowired
    private InvoiceJPARepository invoiceRepository;

    public List<InvoiceResponseModel> getAll() {
        List<InvoiceResponseModel> invoiceList = InvoiceMapper.INSTANCE.mapToCustomerResponseModelList(invoiceRepository.findAll());
        if (CollectionUtils.isEmpty(invoiceList)) {
            return Collections.emptyList();
        }
        invoiceList.forEach(e -> e.setAmount(e.getRate() * e.getQuantity()));
        return invoiceList;
    }

    public InvoiceResponseModel getByID(int id) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            final InvoiceResponseModel response = convertInvoiceEntityIntoResponseModel(invoiceOptional.get());
            response.setProductDetails(productService.getByID(response.getProduct()));
            response.setCustomerDetails(customerService.getCustomerByID(response.getCustomer()));
            return response;
        }
        return null;
    }

    public InvoiceResponseModel add(Invoice invoice) {
        this.validateInvoice(invoice);
        invoice = invoiceRepository.save(invoice);
        return convertInvoiceEntityIntoResponseModel(invoice);
    }
    
    private void validateInvoice(final Invoice invoice) {
        if (invoice.getCustomer() == null) {
            throw new BadRequestException("customer must not be null");
        }
        final CustomerResponseModel customer = customerService.getCustomerByID(invoice.getCustomer());
        if (customer == null) {
            throw new BadRequestException(String.format("customer with id '%d' is not present in the system", invoice.getCustomer()));
        }
        if (invoice.getProduct() == null) {
            throw new BadRequestException("product must not be null");
        }
        final ProductResponseModel product = productService.getByID(invoice.getProduct());
        if (customer == null) {
            throw new BadRequestException(String.format("product with id '%d' is not present in the system", invoice.getProduct()));
        }
        if (invoice.getRate() == null) {
            invoice.setRate(product.getRate());
        }
    }

    private InvoiceResponseModel convertInvoiceEntityIntoResponseModel(final Invoice invoice) {
        final InvoiceResponseModel invoiceResponseModel = InvoiceMapper.INSTANCE.mapToCustomerResponseModel(invoice);
        invoiceResponseModel.setAmount(invoice.getRate() * invoice.getQuantity());
        return invoiceResponseModel;
    }

    @Override
    public InvoiceResponseModel deleteById(int id) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            invoiceRepository.delete(invoice);
            return convertInvoiceEntityIntoResponseModel(invoice);
        }
        return null;
    }

}

