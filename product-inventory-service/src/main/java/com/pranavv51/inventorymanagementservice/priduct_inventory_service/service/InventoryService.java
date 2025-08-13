package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.InventoryRepo;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepo inventoryRepo;
    private final ProductRepo productRepo;

    public InventoryService(InventoryRepo inventoryRepo, ProductRepo productRepo) {
        this.inventoryRepo = inventoryRepo;
        this.productRepo = productRepo;
    }

    private void
}
