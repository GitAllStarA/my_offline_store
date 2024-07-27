package com.demo.backend.sbmssf.service;


import com.demo.backend.sbmssf.entity.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    List<Store> getAllStores();
    Optional<Store> getStoreById(Long id);
    Store createStore(Store store);
    Optional<Store> updateStore(Long id, Store storeDetails);
    boolean deleteStore(Long id);
}
