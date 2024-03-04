package com.Gerturde.InventoryMgtSystem.repository;

import com.Gerturde.InventoryMgtSystem.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepo extends JpaRepository<OrderItem, UUID> {
    List<OrderItem> getOrderItemsByProduct(UUID id);
}
