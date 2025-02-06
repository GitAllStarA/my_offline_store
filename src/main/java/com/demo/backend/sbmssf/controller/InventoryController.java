package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.entity.Inventory;
import com.demo.backend.sbmssf.model.Count;
import com.demo.backend.sbmssf.repository.Repository;
import com.demo.backend.sbmssf.service.serviceImpl.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    @Autowired
    private InventoryServiceImpl inventoryService;

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

    @GetMapping("/count/{storeId}")
    public ResponseEntity<?> getStoreTotalInventoryCount(@PathVariable Long storeId) {
        Long xcount = inventoryService.getInventoryOfStore(storeId);
        if (xcount != null)
            return ResponseEntity.ok( new Count(storeId, inventoryService.getInventoryOfStore(storeId)));
        return ResponseEntity.ok(new Count(storeId, 0L));
    }

    @GetMapping("/storeIdInventory/{storeId}")
    public ResponseEntity<?> getStoreFullInventory(@PathVariable Long storeId) {
        List<Inventory> xdata = inventoryService.getStoreInventoryDetailsFull(storeId);
        if (xdata.isEmpty()) {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        else {
            return ResponseEntity.ok(xdata);
        }
    }

    @GetMapping("/count/store/{storeId}/product/{productId}")
    public ResponseEntity<?> getProductIdCount(@PathVariable("storeId") Long storeId,
                                             @PathVariable("productId") Long productId) {
        if (inventoryService.getProductCountOfStore(storeId, productId) != null)
           return ResponseEntity.ok(inventoryService.getProductCountOfStore(storeId, productId));
        return ResponseEntity.ok(0);
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

