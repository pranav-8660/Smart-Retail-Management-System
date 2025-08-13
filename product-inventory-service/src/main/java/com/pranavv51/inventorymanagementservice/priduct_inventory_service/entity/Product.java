package com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String productDesc;
    private BigDecimal productPrice;


    public Product(String name,String desc,BigDecimal price){
        this.productName = name;
        this.productDesc=desc;
        this.productPrice = price;
    }

}
