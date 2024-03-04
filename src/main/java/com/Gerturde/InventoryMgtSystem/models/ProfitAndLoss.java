package com.Gerturde.InventoryMgtSystem.models;

import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "profit_loss")
public class ProfitAndLoss {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    @Column(name="total_revenue")
    private BigDecimal totalRevenue;
    @Column(name="total_cogs")
    private BigDecimal totalCOGS;
    @Column(name="total_operating_expenses")
    private BigDecimal totalOperatingExpenses;
    @Column(name="gross_profit")
    private BigDecimal grossProfit;
    @Column(name="net_profit")
    private BigDecimal netProfit;
}
