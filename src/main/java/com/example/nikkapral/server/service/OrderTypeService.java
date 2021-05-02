package com.example.nikkapral.server.service;

import com.example.nikkapral.server.entity.OrderType;
import com.example.nikkapral.server.repository.OrderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTypeService {
    @Autowired
    private OrderTypeRepository ordertypeRepository;

    public void create(OrderType orderType){
        ordertypeRepository.save(orderType);
    }

    public List<OrderType> findAll(){
        return ordertypeRepository.findAll();
    }

    public OrderType find(Long id){ return ordertypeRepository.getOne(id); }

    public void delete(Long id){ ordertypeRepository.deleteById(id); }
}

