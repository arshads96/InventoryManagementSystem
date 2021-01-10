package com.arshad.monolith.InventoryManagementSystem.repo;

import com.arshad.monolith.InventoryManagementSystem.beans.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceJPARepository extends JpaRepository<Invoice, Integer>  {
}

