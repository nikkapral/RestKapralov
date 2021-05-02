package com.example.nikkapral.server.service;

import com.example.nikkapral.server.entity.Order;
import com.example.nikkapral.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void create(Order order){
        orderRepository.save(order);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order find(Long id){ return orderRepository.getOne(id); }

    public void delete(Long id){ orderRepository.deleteById(id); }
}
