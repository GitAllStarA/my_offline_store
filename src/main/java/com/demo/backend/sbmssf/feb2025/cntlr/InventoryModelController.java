package com.demo.backend.sbmssf.feb2025.cntlr;

import com.demo.backend.sbmssf.feb2025.InventoryModel;
import com.demo.backend.sbmssf.feb2025.svc.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/inventoryModel")
public class InventoryModelController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/{storeModelId}")
    public ResponseEntity<List<InventoryModel>> getInventoryByStore(@PathVariable Long storeModelId) {
        List<InventoryModel> inventory = inventoryService.getInventoryByStore(storeModelId);


        if (inventory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content if no inventory
        } else {
            return new ResponseEntity<>(inventory, HttpStatus.OK); // 200 OK if inventory is found
        }
    }
}
