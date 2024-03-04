package com.Gerturde.InventoryMgtSystem.service;

import com.Gerturde.InventoryMgtSystem.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    Optional<Product> findByID(UUID id);
    boolean deleteById(UUID id);
    long countProducts();
}
