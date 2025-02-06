package com.demo.backend.sbmssf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorePeripheral {

    public StorePeripheral(Long storePeripheralsId, int quantity, String direction) {
        this.storePeripheralsId = storePeripheralsId;
        this.quantity = quantity;
        this.direction = direction;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storePeripheralsId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @Embedded
    private Store store;

    @ManyToOne
    @JoinColumn(name = "peripherals_id")
    @Embedded
    private Peripheral peripheral;

    private int quantity;

    private String direction;

    // Getters and setters
}
