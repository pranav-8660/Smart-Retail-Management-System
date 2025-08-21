package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Inventory;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.InventoryRepo;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InventoryService {

    private final InventoryRepo inventoryRepo;
    private final ProductRepo productRepo;

    public InventoryService(InventoryRepo inventoryRepo, ProductRepo productRepo) {
        this.inventoryRepo = inventoryRepo;
        this.productRepo = productRepo;
    }

    public void deleteInventory(long pid){
        inventoryRepo.delete(inventoryRepo.findByProductId(pid));
    }

    @Transactional
    public boolean updateInventory(Product product,long newQuantity){
        if(productRepo.existsById(product.getProductId()) && inventoryRepo.existsById(product.getProductId())){
            Inventory thisInventory = inventoryRepo.findByProductId(product.getProductId());
            thisInventory.setProductQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public Product createInventoryInitially(Product newproduct){
        inventoryRepo.save(new Inventory(newproduct,0)); //creating the inventory for the product also, keeping the initial qty as 0
        return productRepo.save(newproduct);
    }
}
