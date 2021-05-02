package com.example.nikkapral.server.controller;

import com.example.nikkapral.server.entity.Barber;
import com.example.nikkapral.server.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BarberController {
    private BarberService barberService;

    @Autowired
    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    @PostMapping(value = "/barbers")
    public ResponseEntity<?> create(@RequestBody Barber barber){
        barberService.create(barber);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/barbers")
    public ResponseEntity<List<Barber>> findAll(){
        final List<Barber> barberList = barberService.findAll();

        return barberList != null && !barberList.isEmpty()
                ? new ResponseEntity<>(barberList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/barbers/{id}")
    public ResponseEntity<Barber> find(@PathVariable(name="id") Long id){
        final Barber barber = barberService.find(id);

        return barber != null
                ? new ResponseEntity<>(barber, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/barber")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        barberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}