package com.example.nikkapral.server.service;

import com.example.nikkapral.server.entity.Barber;
import com.example.nikkapral.server.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {
    @Autowired
    private BarberRepository barberRepository;

    public void create(Barber barber){
        barberRepository.save(barber);
    }

    public List<Barber> findAll(){
        return barberRepository.findAll();
    }

    public Barber find(Long id){ return barberRepository.getOne(id); }

    public void delete(Long id){ barberRepository.deleteById(id); }
}

