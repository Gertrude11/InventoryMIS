package com.Gerturde.InventoryMgtSystem.dto;

import com.Gerturde.InventoryMgtSystem.models.Order;
import com.Gerturde.InventoryMgtSystem.models.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

    private UUID id;
    private Order order;
    private Product product;
    private Integer quantity;
    private BigDecimal purchase_price;
}
