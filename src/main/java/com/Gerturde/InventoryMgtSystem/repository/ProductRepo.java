package com.Gerturde.InventoryMgtSystem.repository;

import com.Gerturde.InventoryMgtSystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {
}
