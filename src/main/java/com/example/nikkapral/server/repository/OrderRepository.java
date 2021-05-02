package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
