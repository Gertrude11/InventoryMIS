package com.Gerturde.InventoryMgtSystem.service;

import com.Gerturde.InventoryMgtSystem.models.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> getAllOrders();
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    Optional<Order> findByID(UUID id);
    Boolean deleteById(UUID id);
    long countOrders();
    List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);
    List<Order> getOrdersByProduct(UUID productId);
}
