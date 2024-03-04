package com.Gerturde.InventoryMgtSystem.service.implementation;

import com.Gerturde.InventoryMgtSystem.models.Stock;
import com.Gerturde.InventoryMgtSystem.repository.StockRepo;
import com.Gerturde.InventoryMgtSystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockImpl implements StockService {

    @Autowired
    StockRepo repo;
    @Override
    public List<Stock> getAllStocks() {
        return repo.findAll();
    }

    @Override
    public Stock saveStock(Stock stock) {
        if (stock != null){
            repo.save(stock);
            return stock;
        }else{
            return null;
        }
    }

    @Override
    public Stock updateStock(Stock stock) {

        // Retrieve current stock from the database
        Stock found = repo.findById(stock.getId()).orElse(null);

        if (found != null) {
            // Update quantity based on whether stock is increased or decreased
            int newQuantity = stock.getQuantity() + stock.getQuantity();
            found.setQuantity(newQuantity);

            // Update total_price based on the updated quantity and unit_price
            BigDecimal newTotalPrice = BigDecimal.valueOf(newQuantity).multiply(found.getUnit_price());
            found.setTotal_price(newTotalPrice);

            // Save the updated stock back to the database
            repo.save(stock);
            return  found;

        }
        return null;


    }

    @Override
    public Optional<Stock> findByID(UUID id) {
        if (id != null){
            Stock stock = repo.findById(id).get();
            return Optional.of(stock);
        }else{
            return  Optional.empty();
        }
    }

    @Override
    public boolean deleteById(UUID id) {
        if (id != null){

            repo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public long countStocks() {
      return repo.count();

    }
}
