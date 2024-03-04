package com.Gerturde.InventoryMgtSystem.controllers;

import com.Gerturde.InventoryMgtSystem.models.Order;
import com.Gerturde.InventoryMgtSystem.service.implementation.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderImpl orderImpl;

    //save new order
    @PostMapping("/order/saveOrder")
    public ResponseEntity<?> saveOrder (@RequestBody Order order) {
        if(order!=null){
            Order orderSaved = orderImpl.saveOrder(order);
            return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.BAD_REQUEST);
        }
    }

    //update order
    @PutMapping("/order/updateOrder/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        if (order!=null){
            Order orderUpdated = orderImpl.updateOrder(order);
            return new ResponseEntity<>(orderUpdated, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Invalid input data", HttpStatus.NOT_MODIFIED);
        }
    }

    //get all orders
    @GetMapping("/order/allOrders")
    public ResponseEntity<?> getAllOrders() {
        List<Order> listOfOrders = orderImpl.getAllOrders();

        if (listOfOrders!=null && !listOfOrders.isEmpty()) {
            return new ResponseEntity<>(listOfOrders, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(listOfOrders, HttpStatus.OK);
        }

    }

    //get one order by id
    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOneOrder(@PathVariable UUID id) {
        Optional<Order> order = orderImpl.findByID(id);
        if ( order.isPresent() ) {
            return new ResponseEntity<>( order, HttpStatus.OK);
        }else{
            return new ResponseEntity<>( order, HttpStatus.OK);
        }
    }

    //delete order
    @DeleteMapping("/order/deleteorder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        Boolean flag = orderImpl.deleteById(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
