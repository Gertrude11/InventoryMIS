package com.Gerturde.InventoryMgtSystem.service;

import com.Gerturde.InventoryMgtSystem.models.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem saveOrderItem(OrderItem OrderItem);
    OrderItem updateOrderItem(OrderItem OrderItem);
    Optional<OrderItem> findByID(UUID id);
    boolean deleteById(UUID id);
    long countOrderItems();
    Optional<OrderItem> getOrderItemsByOrder(UUID orderId);
    List<OrderItem> getOrderItemsByProduct(UUID productId);

}
