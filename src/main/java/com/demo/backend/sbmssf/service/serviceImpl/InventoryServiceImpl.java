package com.demo.backend.sbmssf.service.serviceImpl;


import com.demo.backend.sbmssf.entity.Inventory;
import com.demo.backend.sbmssf.repository.InventoryRepository;
import com.example.attstore.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> updateInventory(Long id, Inventory inventoryDetails) {
        return inventoryRepository.findById(id).map(inventory -> {
            inventory.setStore(inventoryDetails.getStore());
            inventory.setProduct(inventoryDetails.getProduct());
            inventory.setQuantity(inventoryDetails.getQuantity());
            return inventoryRepository.save(inventory);
        });
    }

    @Override
    public boolean deleteInventory(Long id) {
        return inventoryRepository.findById(id).map(inventory -> {
            inventoryRepository.delete(inventory);
            return true;
        }).orElse(false);
    }
}
