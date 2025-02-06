package com.demo.backend.sbmssf.feb2025.cntlr;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.svc.StoreLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/storeLayoutModel")
public class StoreLayoutController {
    @Autowired
    private StoreLayoutService storeLayoutService;

    @GetMapping("/{storeModelId}")
    public List<StoreLayoutModel> getLayoutByStore(@PathVariable Long storeModelId) {
        return storeLayoutService.getLayoutByStore(storeModelId);
    }
}
