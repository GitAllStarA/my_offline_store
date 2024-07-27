package com.demo.backend.sbmssf.service.serviceImpl;

import com.demo.backend.sbmssf.entity.Peripheral;
import com.demo.backend.sbmssf.repository.PeripheralRepository;
import com.demo.backend.sbmssf.service.PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeripheralServiceImpl implements PeripheralService {
    @Autowired
    private PeripheralRepository peripheralRepository;

    @Override
    public List<Peripheral> getAllPeripherals() {
        return peripheralRepository.findAll();
    }

    @Override
    public Optional<Peripheral> getPeripheralById(Long id) {
        return peripheralRepository.findById(id);
    }

    @Override
    public Peripheral createPeripheral(Peripheral peripheral) {
        return peripheralRepository.save(peripheral);
    }

    @Override
    public Optional<Peripheral> updatePeripheral(Long id, Peripheral peripheralDetails) {
        return peripheralRepository.findById(id).map(peripheral -> {
            peripheral.setPeripheralsName(peripheralDetails.getPeripheralsName());
            peripheral.setManufacturer(peripheralDetails.getManufacturer());
            peripheral.setVersion(peripheralDetails.getVersion());
            return peripheralRepository.save(peripheral);
        });
    }

    @Override
    public boolean deletePeripheral(Long id) {
        return peripheralRepository.findById(id).map(peripheral -> {
            peripheralRepository.delete(peripheral);
            return true;
        }).orElse(false);
    }
}
