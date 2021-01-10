package com.arshad.monolith.InventoryManagementSystem.repo;

import com.arshad.monolith.InventoryManagementSystem.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer>  {
}

