package com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    private long productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "productId")
    private Product product;

    private long productQuantity;

    //to create inventory
    public Inventory(Product product,long qty){

        this.productId = product.getProductId();
        this.product = product;
        this.productQuantity = qty;

    }

    public void setProductQuantity(long productQuantity){
        this.productQuantity = productQuantity;
    }


}
