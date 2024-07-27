package com.demo.backend.sbmssf.service.serviceImpl;


import com.demo.backend.sbmssf.entity.Store;
import com.demo.backend.sbmssf.repository.StoreRepository;
import com.demo.backend.sbmssf.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Optional<Store> updateStore(Long id, Store storeDetails) {
        return storeRepository.findById(id).map(store -> {
            store.setStoreName(storeDetails.getStoreName());
            store.setCity(storeDetails.getCity());
            store.setState(storeDetails.getState());
            store.setTimezone(storeDetails.getTimezone());
            store.setClosingTime(storeDetails.getClosingTime());
            return storeRepository.save(store);
        });
    }

    @Override
    public boolean deleteStore(Long id) {
        return storeRepository.findById(id).map(store -> {
            storeRepository.delete(store);
            return true;
        }).orElse(false);
    }
}
