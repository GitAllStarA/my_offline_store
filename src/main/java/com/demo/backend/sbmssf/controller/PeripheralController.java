package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.entity.Peripheral;
import com.demo.backend.sbmssf.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peripherals")
public class PeripheralController {
    @Autowired
    private PeripheralService peripheralService;

    @GetMapping
    public List<Peripheral> getAllPeripherals() {
        return peripheralService.getAllPeripherals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peripheral> getPeripheralById(@PathVariable Long id) {
        return peripheralService.getPeripheralById(id)
                .map(peripheral -> ResponseEntity.ok().body(peripheral))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Peripheral createPeripheral(@RequestBody Peripheral peripheral) {
        return peripheralService.createPeripheral(peripheral);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peripheral> updatePeripheral(@PathVariable Long id, @RequestBody Peripheral peripheralDetails) {
        return peripheralService.updatePeripheral(id, peripheralDetails)
                .map(peripheral -> ResponseEntity.ok().body(peripheral))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeripheral(@PathVariable Long id) {
        return peripheralService.deletePeripheral(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
