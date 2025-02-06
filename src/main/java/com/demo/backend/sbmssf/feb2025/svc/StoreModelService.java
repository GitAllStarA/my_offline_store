package com.demo.backend.sbmssf.feb2025.svc;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import com.demo.backend.sbmssf.feb2025.StoreModel;
import com.demo.backend.sbmssf.feb2025.repo.StoreModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreModelService {
    @Autowired
    private StoreModelRepository storeModelRepository;

    public List<StoreModel> getAllStores() {
        return storeModelRepository.findAll();
    }

    public Optional<StoreModel> getStoreById(Long id) {
        return storeModelRepository.findById(id);
    }
}
