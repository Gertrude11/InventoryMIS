package com.Gerturde.InventoryMgtSystem.controllers;


import com.Gerturde.InventoryMgtSystem.models.Product;
import com.Gerturde.InventoryMgtSystem.service.implementation.ProductImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class ProductController {

    @Autowired
    private ProductImpl productImpl;

    //save new product
    @PostMapping("/product/saveProduct")
    public ResponseEntity<?> saveProduct (@RequestBody Product product) {
        if(product!=null){
            Product productSaved = productImpl.saveProduct(product);
            return new ResponseEntity<>(productSaved, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);
        }
    }

    //update product
    @PutMapping("/product/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        if (product!=null){
            Product productUpdated = productImpl.updateProduct(product);
            return new ResponseEntity<>(productUpdated, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.NOT_MODIFIED);
        }
    }

    //get all products
    @GetMapping("/product/allProducts")
    public ResponseEntity<?> getAllProducts() {
        List<Product> listOfProducts = productImpl.getAllProducts();

        if (listOfProducts!=null && !listOfProducts.isEmpty()) {
            return new ResponseEntity<>(listOfProducts, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(listOfProducts, HttpStatus.OK);
        }

    }

    //get one product by id
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable UUID id) {
        Optional<Product> product = productImpl.findByID(id);
        if ( product.isPresent() ) {
            return new ResponseEntity<>( product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>( product, HttpStatus.OK);
        }
    }

    //delete product
    @DeleteMapping("/product/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        Boolean flag = productImpl.deleteById(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
