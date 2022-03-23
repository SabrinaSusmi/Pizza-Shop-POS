package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable("id") String orderId){
        return orderService.findOrderById(orderId);
    }
}
