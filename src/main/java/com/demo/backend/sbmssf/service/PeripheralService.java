package com.demo.backend.sbmssf.service;


import com.demo.backend.sbmssf.entity.Peripheral;

import java.util.List;
import java.util.Optional;

public interface PeripheralService {
    List<Peripheral> getAllPeripherals();
    Optional<Peripheral> getPeripheralById(Long id);
    Peripheral createPeripheral(Peripheral peripheral);
    Optional<Peripheral> updatePeripheral(Long id, Peripheral peripheralDetails);
    boolean deletePeripheral(Long id);
}
