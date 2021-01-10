package com.arshad.monolith.InventoryManagementSystem.repo;

import com.arshad.monolith.InventoryManagementSystem.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Integer>  {
}

