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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storePeripheralsId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "peripherals_id")
    private Peripheral peripheral;

    private int quantity;

    // Getters and setters
}
