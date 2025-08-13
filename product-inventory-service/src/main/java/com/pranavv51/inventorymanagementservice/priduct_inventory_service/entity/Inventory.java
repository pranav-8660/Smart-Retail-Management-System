package com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Inventory")
@Getter
@Setter
@AllArgsConstructor
public class Inventory {

    @Id
    private Long productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "productId")
    private Product product;

    private Long productQuantity;

}
