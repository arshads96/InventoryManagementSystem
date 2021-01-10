package com.arshad.monolith.InventoryManagementSystem.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InvoiceResponseModel {

    private int id;

    private String number;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date invoiceDate;

    private Integer customer;

    private CustomerResponseModel customerDetails;

    private Integer product;

    private ProductResponseModel productDetails;

    private Double quantity;

    private Double rate;

    private Double amount;

    public InvoiceResponseModel() {
    }

    public InvoiceResponseModel(int id, String number, Date invoiceDate, Integer customer, CustomerResponseModel customerDetails, Integer product, ProductResponseModel productDetails, Double quantity, Double rate, Double amount) {
        this.id = id;
        this.number = number;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
        this.customerDetails = customerDetails;
        this.product = product;
        this.productDetails = productDetails;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public CustomerResponseModel getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerResponseModel customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public ProductResponseModel getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductResponseModel productDetails) {
        this.productDetails = productDetails;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
