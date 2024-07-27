package com.demo.backend.sbmssf.repository;

import com.demo.backend.sbmssf.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
