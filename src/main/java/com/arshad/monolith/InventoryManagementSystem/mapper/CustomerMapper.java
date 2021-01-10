package com.arshad.monolith.InventoryManagementSystem.mapper;

import com.arshad.monolith.InventoryManagementSystem.beans.Customer;
import com.arshad.monolith.InventoryManagementSystem.beans.CustomerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseModel mapToCustomerResponseModel(final Customer customer);

    List<CustomerResponseModel> mapToCustomerResponseModelList(final List<Customer> customerList);
}
