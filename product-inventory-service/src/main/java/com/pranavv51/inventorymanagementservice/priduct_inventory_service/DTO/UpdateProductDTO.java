package com.pranavv51.inventorymanagementservice.priduct_inventory_service.DTO;

import java.math.BigDecimal;

public class UpdateProductDTO {

    private Long productId;
    private String newOrOldProductName;
    private String newOrOldProductDesc;
    private BigDecimal newOrOldProductPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getNewOrOldProductName() {
        return newOrOldProductName;
    }

    public void setNewOrOldProductName(String newOrOldProductName) {
        this.newOrOldProductName = newOrOldProductName;
    }

    public String getNewOrOldProductDesc() {
        return newOrOldProductDesc;
    }

    public void setNewOrOldProductDesc(String newOrOldProductDesc) {
        this.newOrOldProductDesc = newOrOldProductDesc;
    }

    public BigDecimal getNewOrOldProductPrice() {
        return newOrOldProductPrice;
    }

    public void setNewOrOldProductPrice(BigDecimal newOrOldProductPrice) {
        this.newOrOldProductPrice = newOrOldProductPrice;
    }

    public UpdateProductDTO(Long productId, String newOrOldProductName, String newOrOldProductDesc, BigDecimal newOrOldProductPrice) {
        this.productId = productId;
        this.newOrOldProductName = newOrOldProductName;
        this.newOrOldProductDesc = newOrOldProductDesc;
        this.newOrOldProductPrice = newOrOldProductPrice;
    }
}
