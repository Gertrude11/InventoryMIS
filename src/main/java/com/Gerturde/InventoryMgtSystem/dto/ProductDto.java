package com.Gerturde.InventoryMgtSystem.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private List<StockDTO> stockRecords;
    private List<OrderDTO> orders;
    private List<ProfitAndLossDTO> productProfitLossList;
}
