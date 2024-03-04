package com.Gerturde.InventoryMgtSystem.service;

import com.Gerturde.InventoryMgtSystem.models.Stock;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockService {
    List<Stock> getAllStocks();
    Stock saveStock(Stock stock);
    Stock updateStock(Stock stock);
    Optional<Stock> findByID(UUID id);
    boolean deleteById(UUID id);
    long countStocks();
}
