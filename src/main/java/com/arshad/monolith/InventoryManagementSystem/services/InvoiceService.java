package com.arshad.monolith.InventoryManagementSystem.services;

import com.arshad.monolith.InventoryManagementSystem.beans.Invoice;
import com.arshad.monolith.InventoryManagementSystem.beans.InvoiceResponseModel;
import java.util.List;

public interface InvoiceService {

    public List<InvoiceResponseModel> getAll();

    public InvoiceResponseModel getByID(int id);

    public InvoiceResponseModel add(Invoice invoice);

    public InvoiceResponseModel deleteById(int id);
}
