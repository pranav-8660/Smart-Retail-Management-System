package com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
