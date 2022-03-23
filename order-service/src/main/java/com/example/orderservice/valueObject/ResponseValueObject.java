package com.example.orderservice.valueObject;


import com.example.orderservice.entity.Order;

public class ResponseValueObject{
    private Customer customer;
    private Order order;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}