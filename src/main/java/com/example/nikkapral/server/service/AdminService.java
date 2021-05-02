package com.example.nikkapral.server.service;

import com.example.nikkapral.server.entity.Admin;
import com.example.nikkapral.server.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void create(Admin admin){
        adminRepository.save(admin);
    }

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Admin find(Long id){ return adminRepository.getOne(id); }

    public void delete(Long id){ adminRepository.deleteById(id); }
}
