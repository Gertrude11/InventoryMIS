package com.Gerturde.InventoryMgtSystem.service.implementation;

import com.Gerturde.InventoryMgtSystem.models.Product;
import com.Gerturde.InventoryMgtSystem.repository.ProductRepo;
import com.Gerturde.InventoryMgtSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepo repo;
    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        repo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        repo.save(product);

        return product;
    }

    @Override
    public Optional<Product> findByID(UUID id) {
        return repo.findById(id);
    }

    @Override
    public boolean deleteById(UUID id) {
        Product product = repo.findById(id).orElse(null);
        if(product!=null){
            repo.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public long countProducts() {

        return repo.count();
    }
}
