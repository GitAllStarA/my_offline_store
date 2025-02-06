package com.demo.backend.sbmssf.feb2025;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_layout_model")
public class StoreLayoutModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id", nullable = false)  // Treat store_id as a normal column
    private Long storeModelId;

    private int gridX;
    private int gridY;
    private String sectionName;

    @Column(name = "inventory_id", nullable = false)
    private Long inventoryModelId;

    // Getters and Setters
}
