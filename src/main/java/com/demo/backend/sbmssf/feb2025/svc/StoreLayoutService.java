package com.demo.backend.sbmssf.feb2025.svc;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.repo.StoreLayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreLayoutService {
    @Autowired
    private StoreLayoutRepository storeLayoutRepository;

    public List<StoreLayoutModel> getLayoutByStore(Long storeModelId) {
        return storeLayoutRepository.findByStoreModelId(storeModelId);
    }
}
