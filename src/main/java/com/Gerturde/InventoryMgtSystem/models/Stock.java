package com.Gerturde.InventoryMgtSystem.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Enumerated(EnumType.STRING)
    private ELocation location;
    private Integer quantity;
    private BigDecimal unit_price;
    private BigDecimal total_price;
    @CreationTimestamp
    private LocalDate added_date;
}
