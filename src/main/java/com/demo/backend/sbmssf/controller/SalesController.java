package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.entity.Sales;
import com.demo.backend.sbmssf.service.serviceImpl.SalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Long id) {
        return salesService.getSaleById(id)
                .map(sale -> ResponseEntity.ok().body(sale))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sales createSale(@RequestBody Sales sale) {
        return salesService.createSale(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSale(@PathVariable Long id, @RequestBody Sales saleDetails) {
        return salesService.updateSale(id, saleDetails)
                .map(sale -> ResponseEntity.ok().body(sale))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        return salesService.deleteSale(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
