package com.arshad.monolith.InventoryManagementSystem.services;

import com.arshad.monolith.InventoryManagementSystem.beans.Product;
import com.arshad.monolith.InventoryManagementSystem.beans.ProductResponseModel;

import java.util.List;

public interface ProductService {

    public List<ProductResponseModel> getAll();

    public ProductResponseModel getByID(int id);

    public ProductResponseModel add(Product product);

    public ProductResponseModel deleteById(int id);
}
