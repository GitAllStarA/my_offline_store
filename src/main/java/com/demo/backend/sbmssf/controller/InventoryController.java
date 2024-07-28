package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.entity.Inventory;
import com.example.attstore.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id)
                .map(inventory -> ResponseEntity.ok().body(inventory))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        return inventoryService.updateInventory(id, inventoryDetails)
                .map(inventory -> ResponseEntity.ok().body(inventory))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        return inventoryService.deleteInventory(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}

