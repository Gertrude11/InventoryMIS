package com.Gerturde.InventoryMgtSystem.controllers;

import com.Gerturde.InventoryMgtSystem.models.Stock;
import com.Gerturde.InventoryMgtSystem.service.implementation.StockImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockImpl stockImpl;


    //save new Stock
    @PostMapping("/stock/saveStock")
    public ResponseEntity<?> saveStock (@RequestBody Stock stock) {
        if(stock!=null){
            Stock StockSaved = stockImpl.saveStock(stock);
            return new ResponseEntity<>(StockSaved, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);
        }
    }

    //update Stock
    @PutMapping("/Stock/updateStock/{id}")
    public ResponseEntity<?> updateStock(@PathVariable UUID id, @RequestBody Stock stock) {
        if (stock!=null){
            Stock StockUpdated = stockImpl.updateStock(stock);
            return new ResponseEntity<>(StockUpdated, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.NOT_MODIFIED);
        }
    }

    //get all Stocks
    @GetMapping("/Stock/allStocks")
    public ResponseEntity<?> getAllStocks() {
        List<Stock> listOfStocks = stockImpl.getAllStocks();

        if (listOfStocks!=null && !listOfStocks.isEmpty()) {
            return new ResponseEntity<>(listOfStocks, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(listOfStocks, HttpStatus.OK);
        }

    }

    //get one Stock by id
    @GetMapping("/Stock/{id}")
    public ResponseEntity<?> getOneStock(@PathVariable UUID id) {
        Optional<Stock> Stock = stockImpl.findByID(id);
        if ( Stock.isPresent() ) {
            return new ResponseEntity<>( Stock, HttpStatus.OK);
        }else{
            return new ResponseEntity<>( Stock, HttpStatus.OK);
        }
    }

    //delete Stock
    @DeleteMapping("/Stock/deleteStock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable UUID id) {
        Boolean flag = stockImpl.deleteById(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
