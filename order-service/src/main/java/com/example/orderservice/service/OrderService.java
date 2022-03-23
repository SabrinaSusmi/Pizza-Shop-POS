package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.valueObject.Customer;
import com.example.orderservice.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(String orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Autowired
    private RestTemplate restTemplate;

    public ResponseValueObject getUserWithDepartment(String orderId) {
        ResponseValueObject ResponseValueObject = new ResponseValueObject();

        Order order = orderRepository.findOrderById(orderId);
        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" + order.getCustomerId(), Customer.class);

        // The bellow line is also correct. static port is replaced by service
        // Customer customer = restTemplate.getForObject("http://localhost:9001/customers/" + order.getCustomerId(), Customer.class);

        ResponseValueObject.setCustomer(customer);
        ResponseValueObject.setOrder(order);

        return ResponseValueObject;
    }
}