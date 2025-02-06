package com.demo.backend.sbmssf.feb2025.cntlr;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.StoreModel;
import com.demo.backend.sbmssf.feb2025.svc.StoreModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/storesModel")
public class StoreModelController {
    @Autowired
    private StoreModelService storeModelService;

    @GetMapping
    public List<StoreModel> getAllStores() {
        return storeModelService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreModel> getStoreById(@PathVariable Long id) {
        return storeModelService.getStoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
