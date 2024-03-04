package com.Gerturde.InventoryMgtSystem.service.implementation;

import com.Gerturde.InventoryMgtSystem.models.Order;
import com.Gerturde.InventoryMgtSystem.models.OrderItem;
import com.Gerturde.InventoryMgtSystem.repository.OrderRepo;
import com.Gerturde.InventoryMgtSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepository;


    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
         return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        // Retrieve the existing order from the database
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);

        if (existingOrder != null) {
            // Update fields in the existing order
            existingOrder.setLocation(order.getLocation());
            existingOrder.setTotal_price(order.getTotal_price());

            // Update or create order items
            updateOrderItems(existingOrder, order.getOrderItems());

            // Save the updated order
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Order> findByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(UUID id) {
        if (id != null){

            orderRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public long countOrders() {

        return orderRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        // Retrieve orders within the specified date range
        return orderRepository.findByPurchaseDateBetween(startDate, endDate);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersByProduct(UUID productId) {
        // Retrieve orders that contain the specified product
        return orderRepository.findByOrderItems_Product_Id(productId);
    }


    private void updateOrderItems(Order orderToUpdate, List<OrderItem> updatedOrderItems) {
        // Remove existing order items not present in the updated list
        orderToUpdate.getOrderItems().removeIf(existingItem ->
                updatedOrderItems.stream().noneMatch(updatedItem -> updatedItem.getId().equals(existingItem.getId())));

        // Update or add new order items
        for (OrderItem updatedItem : updatedOrderItems) {
            Optional<OrderItem> existingItem = orderToUpdate.getOrderItems().stream()
                    .filter(item -> item.getId().equals(updatedItem.getId()))
                    .findFirst();

            if (existingItem.isPresent()) {
                // Update existing order item
                existingItem.get().setQuantity(updatedItem.getQuantity());
                existingItem.get().setProduct(updatedItem.getProduct());
                existingItem.get().setPurchase_price(updatedItem.getPurchase_price());
            } else {
                // Add new order item
                updatedItem.setOrder(orderToUpdate);
                orderToUpdate.getOrderItems().add(updatedItem);
            }
        }
    }

}
