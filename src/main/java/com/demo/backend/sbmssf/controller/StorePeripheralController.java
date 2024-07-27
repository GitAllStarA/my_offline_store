package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.entity.StorePeripheral;
import com.demo.backend.sbmssf.service.StorePeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeperipherals")
public class StorePeripheralController {
    @Autowired
    private StorePeripheralService storePeripheralService;

    @GetMapping
    public List<StorePeripheral> getAllStorePeripherals() {
        return storePeripheralService.getAllStorePeripherals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorePeripheral> getStorePeripheralById(@PathVariable Long id) {
        return storePeripheralService.getStorePeripheralById(id)
                .map(storePeripheral -> ResponseEntity.ok().body(storePeripheral))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StorePeripheral createStorePeripheral(@RequestBody StorePeripheral storePeripheral) {
        return storePeripheralService.createStorePeripheral(storePeripheral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StorePeripheral> updateStorePeripheral(@PathVariable Long id, @RequestBody StorePeripheral storePeripheralDetails) {
        return storePeripheralService.updateStorePeripheral(id, storePeripheralDetails)
                .map(storePeripheral -> ResponseEntity.ok().body(storePeripheral))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStorePeripheral(@PathVariable Long id) {
        return storePeripheralService.deleteStorePeripheral(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
