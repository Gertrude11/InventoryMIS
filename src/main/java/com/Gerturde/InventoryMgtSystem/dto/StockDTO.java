package com.Gerturde.InventoryMgtSystem.dto;

import com.Gerturde.InventoryMgtSystem.models.ELocation;
import com.Gerturde.InventoryMgtSystem.models.Product;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDTO {

    private UUID id;
    private Product product;
    private ELocation location;
    private Integer quantity;
    private BigDecimal unit_price;
    private BigDecimal total_price;
    private LocalDate added_date;
}
