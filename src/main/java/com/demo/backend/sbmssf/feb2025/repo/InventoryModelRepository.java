package com.demo.backend.sbmssf.feb2025.repo;

import com.demo.backend.sbmssf.feb2025.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryModelRepository extends JpaRepository<InventoryModel, Long> {
    List<InventoryModel> findByStoreModelId(Long storeId);
}
