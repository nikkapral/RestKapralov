package com.example.nikkapral.server.controller;

import com.example.nikkapral.server.entity.Order;
import com.example.nikkapral.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<?> create(@RequestBody Order order){
        orderService.create(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> findAll(){
        final List<Order> orderList = orderService.findAll();

        return orderList != null && !orderList.isEmpty()
                ? new ResponseEntity<>(orderList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<Order> find(@PathVariable(name="id") Long id){
        final Order order = orderService.find(id);

        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/order")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}