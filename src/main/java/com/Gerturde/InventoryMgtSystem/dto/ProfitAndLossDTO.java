package com.Gerturde.InventoryMgtSystem.dto;

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
public class ProfitAndLossDTO {

    private UUID id;
    private Product product;
    private BigDecimal totalRevenue;
    private BigDecimal totalCOGS;
    private BigDecimal totalOperatingExpenses;
    private BigDecimal grossProfit;
    private BigDecimal netProfit;
}
