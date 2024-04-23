package com.aliflazuardi.inventoryservice.repository;

import com.aliflazuardi.inventoryservice.model.Inventory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findBySkuCode();
}
