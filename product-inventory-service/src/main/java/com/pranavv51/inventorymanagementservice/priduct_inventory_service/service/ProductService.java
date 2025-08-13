package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.DTO.UpdateProductDTO;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {


    //private Product product;

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(String pname, String pdesc, BigDecimal pprice){
        return productRepo.save(new Product(pname,pdesc,pprice));
    }

    //handle the response in the ui for proper success/failure message
    public boolean deleteProduct(String pname){
        Product productToBeDeleted = productRepo.findByProductName(pname);

        if(productToBeDeleted!=null){
            productRepo.delete(productToBeDeleted);
            return true;
        }

        return false;
    }

    public Product updateProduct(String productName, UpdateProductDTO updatedProduct){
        Product productToBeUpdated = productRepo.findByProductName(productName);

        if(productToBeUpdated!=null){
            productRepo.delete(productToBeUpdated);
            return productRepo.save(new Product(updatedProduct.getProductId(),updatedProduct.getNewOrOldProductName(),updatedProduct.getNewOrOldProductDesc(),updatedProduct.getNewOrOldProductPrice()));
        }
        return productToBeUpdated;

    }

}
