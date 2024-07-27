package com.demo.backend.sbmssf.service.serviceImpl;


import com.demo.backend.sbmssf.entity.StorePeripheral;
import com.demo.backend.sbmssf.repository.StorePeripheralRepository;
import com.demo.backend.sbmssf.service.StorePeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorePeripheralServiceImpl implements StorePeripheralService {
    @Autowired
    private StorePeripheralRepository storePeripheralRepository;

    @Override
    public List<StorePeripheral> getAllStorePeripherals() {
        return storePeripheralRepository.findAll();
    }

    @Override
    public Optional<StorePeripheral> getStorePeripheralById(Long id) {
        return storePeripheralRepository.findById(id);
    }

    @Override
    public StorePeripheral createStorePeripheral(StorePeripheral storePeripheral) {
        return storePeripheralRepository.save(storePeripheral);
    }

    @Override
    public Optional<StorePeripheral> updateStorePeripheral(Long id, StorePeripheral storePeripheralDetails) {
        return storePeripheralRepository.findById(id).map(storePeripheral -> {
            storePeripheral.setStore(storePeripheralDetails.getStore());
            storePeripheral.setPeripheral(storePeripheralDetails.getPeripheral());
            storePeripheral.setQuantity(storePeripheralDetails.getQuantity());
            return storePeripheralRepository.save(storePeripheral);
        });
    }

    @Override
    public boolean deleteStorePeripheral(Long id) {
        return storePeripheralRepository.findById(id).map(storePeripheral -> {
            storePeripheralRepository.delete(storePeripheral);
            return true;
        }).orElse(false);
    }
}
