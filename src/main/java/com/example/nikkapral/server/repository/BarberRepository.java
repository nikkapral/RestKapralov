package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber,Long> {
}
