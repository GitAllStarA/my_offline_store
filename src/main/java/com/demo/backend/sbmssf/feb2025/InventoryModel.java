package com.demo.backend.sbmssf.feb2025;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory_model")  // Ensure this matches your actual DB table
public class InventoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id", nullable = false)  // Treat store_id as a normal column
    private Long storeModelId;

    private String name;
    private String category;
    private int stockCount;
    private BigDecimal price;
    private String specifications;
    private String imageUrl;

    // Getters and Setters
}
