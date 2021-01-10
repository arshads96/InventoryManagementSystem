package com.arshad.monolith.InventoryManagementSystem.controller;

import com.arshad.monolith.InventoryManagementSystem.beans.Customer;
import com.arshad.monolith.InventoryManagementSystem.beans.CustomerResponseModel;
import com.arshad.monolith.InventoryManagementSystem.services.CustomerService;
import com.arshad.monolith.InventoryManagementSystem.utils.CustomerConstants;
import com.arshad.monolith.InventoryManagementSystem.utils.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {


    @Autowired
    @Qualifier(value = "customerServiceDbImpl")
    private CustomerService customerServiceImpl;

    @GetMapping
    public List<CustomerResponseModel> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerResponseModel getCustomer(@PathVariable int id) {
        CustomerResponseModel customer = customerServiceImpl.getCustomerByID(id);
        if (customer == null) {
            throw new CustomerNotFoundException(String.format(CustomerConstants.CANNOT_FIND_Customer, id));
        }
        return customer;
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerServiceImpl.addCustomer(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        CustomerResponseModel customer = customerServiceImpl.deleteCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException(String.format(CustomerConstants.CANNOT_DELETE_Customer, id));
        }
        return ResponseEntity.noContent().build();
    }


}
