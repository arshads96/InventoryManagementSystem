package com.arshad.monolith.InventoryManagementSystem.beans;

public class ProductResponseModel {

    private int id;
    private String name;
    private String code;
    private Double rate;

    public ProductResponseModel() {
    }

    public ProductResponseModel(int id, String name, String code, Double rate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ProductResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
