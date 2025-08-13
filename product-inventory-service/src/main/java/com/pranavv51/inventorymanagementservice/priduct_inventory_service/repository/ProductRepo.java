package com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    public Product findByProductName(String productName);
}
