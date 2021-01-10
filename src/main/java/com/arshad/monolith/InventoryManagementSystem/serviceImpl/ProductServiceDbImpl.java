package com.arshad.monolith.InventoryManagementSystem.serviceImpl;

import com.arshad.monolith.InventoryManagementSystem.beans.Product;
import com.arshad.monolith.InventoryManagementSystem.beans.ProductResponseModel;
import com.arshad.monolith.InventoryManagementSystem.mapper.ProductMapper;
import com.arshad.monolith.InventoryManagementSystem.repo.ProductJPARepository;
import com.arshad.monolith.InventoryManagementSystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("productServiceDbImpl")
public class ProductServiceDbImpl implements ProductService {

    @Autowired
    private ProductJPARepository productRepository;

    public List<ProductResponseModel> getAll() {
        List<ProductResponseModel> productList = ProductMapper.INSTANCE.mapToUserResponseModelList(productRepository.findAll());
        return productList;
    }

    public ProductResponseModel getByID(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return ProductMapper.INSTANCE.mapToUserResponseModel(productOptional.get());
        }
        return null;
    }

    public ProductResponseModel add(Product product) {
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.mapToUserResponseModel(product);
    }

    @Override
    public ProductResponseModel deleteById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return ProductMapper.INSTANCE.mapToUserResponseModel(product);
        }
        return null;
    }

}

