package com.demo.backend.sbmssf.feb2025.repo;

import com.demo.backend.sbmssf.feb2025.StoreLayoutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreLayoutRepository extends JpaRepository<StoreLayoutModel, Long> {
    List<StoreLayoutModel> findByStoreModelId(Long storeModelId);

    Optional<StoreLayoutModel> findById(Long id);
}
