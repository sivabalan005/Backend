package com.ecom.orderrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.orderentity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // You can add custom queries here if needed
}

