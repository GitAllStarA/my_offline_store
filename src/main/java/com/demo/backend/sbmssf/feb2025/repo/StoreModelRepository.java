package com.demo.backend.sbmssf.feb2025.repo;

import com.demo.backend.sbmssf.feb2025.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreModelRepository extends JpaRepository<StoreModel, Long> {
}
