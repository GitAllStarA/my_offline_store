package com.demo.backend.sbmssf.feb2025.svc;

import com.demo.backend.sbmssf.feb2025.InventoryModel;
import com.demo.backend.sbmssf.feb2025.repo.InventoryModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryModelRepository inventoryModelRepository;

    public List<InventoryModel> getInventoryByStore(Long storeId) {
        return inventoryModelRepository.findByStoreModelId(storeId);
    }
}
