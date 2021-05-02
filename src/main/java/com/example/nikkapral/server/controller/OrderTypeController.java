package com.example.nikkapral.server.controller;

import com.example.nikkapral.server.entity.OrderType;
import com.example.nikkapral.server.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderTypeController {
    private OrderTypeService orderTypeService;

    @Autowired
    public OrderTypeController(OrderTypeService orderTypeService){
        this.orderTypeService = orderTypeService;
    }

    @PostMapping(value = "/orderTypes")
    public ResponseEntity<?> create(@RequestBody OrderType orderType){
        orderTypeService.create(orderType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orderTypes")
    public ResponseEntity<List<OrderType>> findAll(){
        final List<OrderType> orderTypeList = orderTypeService.findAll();

        return orderTypeList != null && !orderTypeList.isEmpty()
                ? new ResponseEntity<>(orderTypeList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orderTypes/{id}")
    public ResponseEntity<OrderType> find(@PathVariable(name="id") Long id){
        final OrderType orderType = orderTypeService.find(id);

        return orderType != null
                ? new ResponseEntity<>(orderType, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/orderType")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        orderTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
