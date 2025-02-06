package com.demo.backend.sbmssf.service;


import com.demo.backend.sbmssf.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> getAllInventories();
    Optional<Inventory> getInventoryById(Long id);
    Inventory createInventory(Inventory inventory);
    Optional<Inventory> updateInventory(Long id, Inventory inventoryDetails);
    boolean deleteInventory(Long id);
    Long getInventoryOfStore(Long storeId);
    Long getProductCountOfStore(Long storeId, Long productId);
    List<Inventory> getStoreInventoryDetailsFull(Long storeId);

}
