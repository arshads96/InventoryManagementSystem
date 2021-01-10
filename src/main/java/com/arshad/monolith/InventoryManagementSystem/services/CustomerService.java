package com.arshad.monolith.InventoryManagementSystem.services;

import com.arshad.monolith.InventoryManagementSystem.beans.Customer;
import com.arshad.monolith.InventoryManagementSystem.beans.CustomerResponseModel;

import java.util.List;

public interface CustomerService {

    public List<CustomerResponseModel> getAllCustomers();

    public CustomerResponseModel getCustomerByID(int id);

    public CustomerResponseModel addCustomer(Customer customer);

    public CustomerResponseModel deleteCustomerById(int id);
}
