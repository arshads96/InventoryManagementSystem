package com.arshad.monolith.InventoryManagementSystem.mapper;

import com.arshad.monolith.InventoryManagementSystem.beans.Invoice;
import com.arshad.monolith.InventoryManagementSystem.beans.InvoiceResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceResponseModel mapToCustomerResponseModel(final Invoice invoice);

    List<InvoiceResponseModel> mapToCustomerResponseModelList(final List<Invoice> invoiceList);
}
