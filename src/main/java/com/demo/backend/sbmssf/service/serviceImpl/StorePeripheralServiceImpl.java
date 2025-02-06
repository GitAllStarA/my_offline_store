package com.demo.backend.sbmssf.service.serviceImpl;


import com.demo.backend.sbmssf.entity.StorePeripheral;
import com.demo.backend.sbmssf.repository.StorePeripheralRepository;
import com.demo.backend.sbmssf.repository.StoreRepository;
import com.demo.backend.sbmssf.service.StorePeripheralService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorePeripheralServiceImpl implements StorePeripheralService {
    @Autowired
    private StorePeripheralRepository storePeripheralRepository;
    private final EntityManagerFactory entityManagerFactory;

    public StorePeripheralServiceImpl(StorePeripheralRepository storePeripheralRepository, EntityManagerFactory entityManagerFactory) {
        this.storePeripheralRepository = storePeripheralRepository;
        this.entityManagerFactory = entityManagerFactory;
    }

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

    @Override
    public Long storePeripheralsCount(Long storeId) {
        return storePeripheralRepository.getStorePeripheralCount(storeId);
    }

    public List<StorePeripheral> getStorePeripheralsDetails(Long storeId) {

        return storePeripheralRepository.getStorePeripheralsDetails(storeId);
    }

    }
