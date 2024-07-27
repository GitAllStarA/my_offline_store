package com.demo.backend.sbmssf.service;

import com.demo.backend.sbmssf.entity.StorePeripheral;

import java.util.List;
import java.util.Optional;

public interface StorePeripheralService {
    List<StorePeripheral> getAllStorePeripherals();
    Optional<StorePeripheral> getStorePeripheralById(Long id);
    StorePeripheral createStorePeripheral(StorePeripheral storePeripheral);
    Optional<StorePeripheral> updateStorePeripheral(Long id, StorePeripheral storePeripheralDetails);
    boolean deleteStorePeripheral(Long id);
}
