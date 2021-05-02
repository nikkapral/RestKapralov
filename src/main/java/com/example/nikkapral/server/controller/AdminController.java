package com.example.nikkapral.server.controller;

import com.example.nikkapral.server.entity.Admin;
import com.example.nikkapral.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping(value = "/admins")
    public ResponseEntity<?> create(@RequestBody Admin admin){
        adminService.create(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/admins")
    public ResponseEntity<List<Admin>> findAll(){
        final List<Admin> adminList = adminService.findAll();

        return adminList != null && !adminList.isEmpty()
                ? new ResponseEntity<>(adminList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/admins/{id}")
    public ResponseEntity<Admin> find(@PathVariable(name="id") Long id){
        final Admin admin = adminService.find(id);

        return admin != null
                ? new ResponseEntity<>(admin, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/admin")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
