package com.demo.backend.sbmssf.repository;

import com.demo.backend.sbmssf.entity.Inventory;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    @Query("SELECT SUM(i.quantity) FROM Inventory i WHERE i.store.storeId = :storeId")
    Long findTotalInventoryOfStore(@Param("storeId") Long storeId);

    @Query("SELECT SUM(i.quantity) FROM Inventory i WHERE i.store.storeId = :storeId and i.product.productId = :productId")
    Long getEachProductCount(@Param("storeId") Long storeId, @Param("productId") Long productId);

    @Query("select i from Inventory i where i.store.storeId = :storeId")
    List<Inventory> getStoreInventoryDetails(@Param("storeId") Long StoreId);

}
