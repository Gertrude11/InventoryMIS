package com.Gerturde.InventoryMgtSystem.service.implementation;

import com.Gerturde.InventoryMgtSystem.models.OrderItem;
import com.Gerturde.InventoryMgtSystem.repository.OrderItemRepo;
import com.Gerturde.InventoryMgtSystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        // Save the order item
        return orderItemRepository.save(orderItem);
    }

    @Override
    @Transactional
    public OrderItem updateOrderItem(OrderItem updatedOrderItem) {
        // Retrieve the existing order item from the database
        Optional<OrderItem> existingOrderItem = orderItemRepository.findById(updatedOrderItem.getId());

        if (existingOrderItem.isPresent()) {
            // Update fields in the existing order item
            OrderItem foundOrderItem = existingOrderItem.get();
            foundOrderItem.setQuantity(updatedOrderItem.getQuantity());
            foundOrderItem.setPurchase_price(updatedOrderItem.getPurchase_price());

            // Update the product (optional, depends on your use case)
            foundOrderItem.setProduct(updatedOrderItem.getProduct());

            // Save the updated order item
            return orderItemRepository.save(foundOrderItem);
        } else {
            // Handle the case where the order item is not found
            // (you might want to throw an exception or handle it according to your business requirements)
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderItem> findByID(UUID id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public boolean deleteById(UUID id) {
        if (id != null){

            orderItemRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public long countOrderItems() {
        return orderItemRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderItem> getOrderItemsByOrder(UUID orderId) {
        // Retrieve order items associated with a specific order
        return orderItemRepository.findById(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItem> getOrderItemsByProduct(UUID productId) {
        // Retrieve order items associated with a specific product
        return orderItemRepository.getOrderItemsByProduct(productId);
    }



}
