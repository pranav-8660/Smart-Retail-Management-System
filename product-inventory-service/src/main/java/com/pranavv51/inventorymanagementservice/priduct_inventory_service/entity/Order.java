package com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.PriductInventoryServiceApplication;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Timer;

@Entity
@Table(name = "Order")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // to handle cart, if multiple products are added to the cart, then we shall create multiple orders for same user at same timestamps
    private long orderId;

    private long userId;

    private long productQuantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private LocalDateTime timeStamp;

    //to create an order
    public Order(long userId,long productQuantity,Product product){
        this.timeStamp = LocalDateTime.now();
        this.productQuantity=productQuantity;
        this.product = product;
        this.userId = userId;
    }
}
