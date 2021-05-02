package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepository extends JpaRepository<OrderType,Long> {
}
