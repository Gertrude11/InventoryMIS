package com.Gerturde.InventoryMgtSystem.repository;

import com.Gerturde.InventoryMgtSystem.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepo extends JpaRepository<Stock, UUID> {
}
