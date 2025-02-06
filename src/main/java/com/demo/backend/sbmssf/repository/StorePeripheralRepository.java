package com.demo.backend.sbmssf.repository;


import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.backend.sbmssf.entity.StorePeripheral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StorePeripheralRepository extends JpaRepository<StorePeripheral, Long> {


    @Query("select sum(sp.quantity) from StorePeripheral sp where sp.store.storeId = :storeId")
    public Long getStorePeripheralCount(@Param("storeId") Long storeId);

    @Query("select sp from StorePeripheral sp where sp.store.storeId = :storeId")
    public List<StorePeripheral> getStorePeripheralsDetails(@Param("storeId") Long storeId);



}

