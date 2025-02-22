package com.demo.backend.sbmssf.feb2025.cntlr;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.svc.StoreLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storeLayoutModel")
public class StoreLayoutController {
    @Autowired
    private StoreLayoutService storeLayoutService;

    @PostMapping("/{storeModelId}")
    public List<StoreLayoutModel> getLayoutByStore(@PathVariable Long storeModelId) {
        return storeLayoutService.getLayoutByStore(storeModelId);
    }

    @PostMapping("/layout/{storeLayoutId}")
    public ResponseEntity<Optional<StoreLayoutModel>> getStoreLayoutById(@PathVariable Long storeLayoutId) {
        return ResponseEntity.ok(storeLayoutService.getStoreLayoutIdService(storeLayoutId));
    }

    String req = "{\"20\": [{\"storeId\": 1, \"inventoryId\": 1, \"category\": \"iPhone Display\", \"rowStart\": 3, \"colStart\": 6, \"rowEnd\": 6, \"colEnd\": 7}], \"21\": [{\"storeId\": 1, \"inventoryId\": 2, \"category\": \"iPhone Display\", \"rowStart\": 4, \"colStart\": 3, \"rowEnd\": 5, \"colEnd\": 4}], \"22\": [{\"storeId\": 1, \"inventoryId\": 4, \"category\": \"Samsung Display\", \"rowStart\": 3, \"colStart\": 2, \"rowEnd\": 4, \"colEnd\": 3}], \"23\": [{\"storeId\": 1, \"inventoryId\": 7, \"category\": \"Accessories\", \"rowStart\": 1, \"colStart\": 3, \"rowEnd\": 3, \"colEnd\": 7}], \"24\": [{\"storeId\": 1, \"inventoryId\": 8, \"category\": \"Billing\", \"rowStart\": 4, \"colStart\": 4, \"rowEnd\": 6, \"colEnd\": 5}], \"25\": [{\"storeId\": 1, \"inventoryId\": 9, \"category\": \"Customer Support\", \"rowStart\": 5, \"colStart\": 3, \"rowEnd\": 6, \"colEnd\": 4}], \"26\": [{\"storeId\": 1, \"inventoryId\": 10, \"category\": \"Waiting Area\", \"rowStart\": 2, \"colStart\": 1, \"rowEnd\": 3, \"colEnd\": 2}], \"27\": [{\"storeId\": 1, \"inventoryId\": 11, \"category\": \"Storage\", \"rowStart\": 4, \"colStart\": 5, \"rowEnd\": 5, \"colEnd\": 6}], \"28\": [{\"storeId\": 1, \"inventoryId\": 12, \"category\": \"Manager Office\", \"rowStart\": 3, \"colStart\": 3, \"rowEnd\": 4, \"colEnd\": 4}], \"29\": [{\"storeId\": 1, \"inventoryId\": 13, \"category\": \"Tech Repairs\", \"rowStart\": 5, \"colStart\": 2, \"rowEnd\": 6, \"colEnd\": 3}], \"36\": [{\"category\": \"Unlocked phones\", \"storeId\": 1, \"inventoryId\": 13, \"rowStart\": 0, \"colStart\": 4, \"rowEnd\": 1, \"colEnd\": 5}], \"37\": [{\"category\": \"Kiosk\", \"storeId\": 1, \"inventoryId\": 14, \"rowStart\": 0, \"colStart\": 5, \"rowEnd\": 1, \"colEnd\": 6}], \"storeInfo\": [{\"id\": 1, \"name\": \"AT&T Store Hutto\", \"address\": \"123 Main St\", \"city\": \"Hutto\", \"state\": \"TX\", \"zipCode\": \"78634\", \"squareFeet\": 2000, \"openingTime\": \"10:00:00\", \"closingTime\": \"20:00:00\"}]}";


    @GetMapping("/layout/save")
    public ResponseEntity<Boolean> getStoreLayoutById() throws IOException {
        return ResponseEntity.ok(storeLayoutService.jsonParse(req));
    }

    @PostMapping("/store-layout-save-map-db")
    public ResponseEntity<String> storeLayoutSaveMap(@RequestBody String requestStr) {
        System.out.println(requestStr);
        storeLayoutService.saveStoreMap(requestStr);
        return ResponseEntity.ok("data saved : "+requestStr);
    }
}
