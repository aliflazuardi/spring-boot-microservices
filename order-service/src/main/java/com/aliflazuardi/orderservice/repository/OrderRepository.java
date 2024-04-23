package com.aliflazuardi.orderservice.repository;

import com.aliflazuardi.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
