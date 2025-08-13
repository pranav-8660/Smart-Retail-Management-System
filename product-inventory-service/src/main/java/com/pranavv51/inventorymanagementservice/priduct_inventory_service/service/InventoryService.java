package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Inventory;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
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

    private boolean updateInventory(Product product,int newQuantity){
        if(productRepo.existsById(product.getProductId())){
            Inventory thisInventory = inventoryRepo.findByProductId(product.getProductId());
            thisInventory.setProductQuantity(newQuantity);
            return true;
        }
        return false;
    }
}
