package com.Gerturde.InventoryMgtSystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String code;
    private String name;
    private String description;

    @OneToMany(mappedBy = "product" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Stock> stockRecords ;

//    @ManyToMany(mappedBy = "orders",cascade = CascadeType.ALL)
//    private List<Order> orders;

    @OneToMany(mappedBy = "products")
    private List<ProfitAndLoss> productProfitLossList;
}
