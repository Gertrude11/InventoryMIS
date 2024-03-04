package com.Gerturde.InventoryMgtSystem.dto;

import com.Gerturde.InventoryMgtSystem.models.ELocation;
import com.Gerturde.InventoryMgtSystem.models.OrderItem;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private UUID id;
    private List<OrderItem> orderItems;
    private ELocation location;
    private BigDecimal total_price;
    private LocalDate purchase_date;
}
