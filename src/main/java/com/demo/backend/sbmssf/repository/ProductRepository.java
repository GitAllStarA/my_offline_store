package com.demo.backend.sbmssf.repository;

import com.demo.backend.sbmssf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
