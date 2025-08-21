package com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {

    public Inventory findByProductId(long productId);
}
