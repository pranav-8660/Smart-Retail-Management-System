package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Inventory;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Order;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.InventoryRepo;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final InventoryService inventoryService;
    private final InventoryRepo inventoryRepo;

    public OrderService(OrderRepo orderRepo, InventoryService inventoryService, InventoryRepo inventoryRepo) {
        this.orderRepo = orderRepo;
        this.inventoryService = inventoryService;
        this.inventoryRepo = inventoryRepo;
    }

    @Transactional
    public Order createOrder(long userId, long requestQuantity, Product product){
        //public Order(long userId,long productQuantity,Product product)

        Inventory inventory = inventoryRepo.findByProductId(product.getProductId());

        if(inventory.getProductQuantity()>=requestQuantity){
            if(inventoryService.updateInventory(product,(inventory.getProductQuantity()-requestQuantity))){
                return orderRepo.save(new Order(userId,requestQuantity,product));
            }
            return null;
        }

        return null;
    }


}
