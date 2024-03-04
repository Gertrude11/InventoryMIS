package com.Gerturde.InventoryMgtSystem.controllers;

import com.Gerturde.InventoryMgtSystem.models.OrderItem;
import com.Gerturde.InventoryMgtSystem.service.implementation.OrderItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/stocks")
public class OrderItemController {
    
    @Autowired
    private OrderItemImpl orderItemImpl;

    //save new OrderItem
    @PostMapping("/OrderItem/saveOrderItem")
    public ResponseEntity<?> saveOrderItem (@RequestBody OrderItem OrderItem) {
        if(OrderItem!=null){
            OrderItem OrderItemSaved = orderItemImpl.saveOrderItem(OrderItem);
            return new ResponseEntity<>(OrderItemSaved, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);
        }
    }

    //update OrderItem
    @PutMapping("/OrderItem/updateOrderItem/{id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable UUID id, @RequestBody OrderItem OrderItem) {
        if (OrderItem!=null){
            OrderItem OrderItemUpdated = orderItemImpl.updateOrderItem(OrderItem);
            return new ResponseEntity<>(OrderItemUpdated, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.NOT_MODIFIED);
        }
    }

    //get all OrderItems
    @GetMapping("/OrderItem/allOrderItems")
    public ResponseEntity<?> getAllOrderItems() {
        List<OrderItem> listOfOrderItems = orderItemImpl.getAllOrderItems();

        if (listOfOrderItems!=null && !listOfOrderItems.isEmpty()) {
            return new ResponseEntity<>(listOfOrderItems, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(listOfOrderItems, HttpStatus.OK);
        }

    }

    //get one OrderItem by id
    @GetMapping("/OrderItem/{id}")
    public ResponseEntity<?> getOneOrderItem(@PathVariable UUID id) {
        Optional<OrderItem> OrderItem = orderItemImpl.findByID(id);
        if ( OrderItem.isPresent() ) {
            return new ResponseEntity<>( OrderItem, HttpStatus.OK);
        }else{
            return new ResponseEntity<>( OrderItem, HttpStatus.OK);
        }
    }

    //delete OrderItem
    @DeleteMapping("/OrderItem/deleteOrderItem/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable UUID id) {
        Boolean flag = orderItemImpl.deleteById(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
