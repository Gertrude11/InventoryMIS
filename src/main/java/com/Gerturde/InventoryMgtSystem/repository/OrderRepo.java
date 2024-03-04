package com.Gerturde.InventoryMgtSystem.repository;


import com.Gerturde.InventoryMgtSystem.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
    List<Order> findByPurchaseDateBetween(LocalDate startDate,LocalDate endDate);
    List<Order> findByOrderItems_Product_Id(UUID id);
}
