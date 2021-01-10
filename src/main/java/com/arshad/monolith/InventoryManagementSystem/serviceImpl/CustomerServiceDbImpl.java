package com.arshad.monolith.InventoryManagementSystem.serviceImpl;

import com.arshad.monolith.InventoryManagementSystem.beans.Customer;
import com.arshad.monolith.InventoryManagementSystem.beans.CustomerResponseModel;
import com.arshad.monolith.InventoryManagementSystem.mapper.CustomerMapper;
import com.arshad.monolith.InventoryManagementSystem.repo.CustomerJPARepository;
import com.arshad.monolith.InventoryManagementSystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("customerServiceDbImpl")
public class CustomerServiceDbImpl implements CustomerService {

    @Autowired
    private CustomerJPARepository customerRepository;

    public List<CustomerResponseModel> getAllCustomers() {
        List<CustomerResponseModel> customerList = CustomerMapper.INSTANCE.mapToCustomerResponseModelList(customerRepository.findAll());
        return customerList;
    }

    public CustomerResponseModel getCustomerByID(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return CustomerMapper.INSTANCE.mapToCustomerResponseModel(customerOptional.get());
        }
        return null;
    }

    public CustomerResponseModel addCustomer(Customer customer) {
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.mapToCustomerResponseModel(customer);
    }

    @Override
    public CustomerResponseModel deleteCustomerById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customerRepository.delete(customer);
            return CustomerMapper.INSTANCE.mapToCustomerResponseModel(customer);
        }
        return null;
    }

}

