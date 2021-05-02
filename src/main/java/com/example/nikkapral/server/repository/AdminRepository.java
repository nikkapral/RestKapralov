package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
