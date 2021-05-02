package com.example.nikkapral.server.repository;

import com.example.nikkapral.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
