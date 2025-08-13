package com.pranavv51.inventorymanagementservice.priduct_inventory_service.service;

import com.pranavv51.inventorymanagementservice.priduct_inventory_service.DTO.UpdateProductDTO;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Inventory;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.entity.Product;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.InventoryRepo;
import com.pranavv51.inventorymanagementservice.priduct_inventory_service.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {


    //private Product product;

    private final ProductRepo productRepo;
    private final InventoryRepo inventoryRepo;

    public ProductService(ProductRepo productRepo, InventoryRepo inventoryRepo) {
        this.productRepo = productRepo;
        this.inventoryRepo = inventoryRepo;
    }

    public Product createProduct(String pname, String pdesc, BigDecimal pprice){

        Product newproduct = new Product(pname,pdesc,pprice);
        inventoryRepo.save(new Inventory(newproduct,0)); //creating the inventory for the product also, keeping the initial qty as 0
        return productRepo.save(newproduct);
    }

    //handle the response in the ui for proper success/failure message
    public boolean deleteProduct(String pname){
        Product productToBeDeleted = productRepo.findByProductName(pname);

        if(productToBeDeleted!=null){
            productRepo.delete(productToBeDeleted); //delete the product
            inventoryRepo.delete(inventoryRepo.findByProductId(productToBeDeleted.getProductId())); //delete the inventory as well
            return true;
        }

        return false;
    }

    public Product updateProduct(String productName, UpdateProductDTO updatedProduct){
        Product productToBeUpdated = productRepo.findByProductName(productName);

        if(productToBeUpdated!=null){
           if(deleteProduct(productName)){
                return productRepo.save(new Product(updatedProduct.getProductId(),updatedProduct.getNewOrOldProductName(),updatedProduct.getNewOrOldProductDesc(),updatedProduct.getNewOrOldProductPrice()));
           }
           return productToBeUpdated;
        }
        return productToBeUpdated;

    }

}
