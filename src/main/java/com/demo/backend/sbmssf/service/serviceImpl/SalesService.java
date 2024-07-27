package com.demo.backend.sbmssf.service.serviceImpl;


import com.demo.backend.sbmssf.entity.Sales;
import com.demo.backend.sbmssf.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Optional<Sales> getSaleById(Long id) {
        return salesRepository.findById(id);
    }

    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }

    public Optional<Sales> updateSale(Long id, Sales saleDetails) {
        return salesRepository.findById(id).map(sale -> {
            sale.setStore(saleDetails.getStore());
            sale.setProduct(saleDetails.getProduct());
            sale.setSaleDate(saleDetails.getSaleDate());
            sale.setQuantitySold(saleDetails.getQuantitySold());
            return salesRepository.save(sale);
        });
    }

    public boolean deleteSale(Long id) {
        return salesRepository.findById(id).map(sale -> {
            salesRepository.delete(sale);
            return true;
        }).orElse(false);
    }
}
