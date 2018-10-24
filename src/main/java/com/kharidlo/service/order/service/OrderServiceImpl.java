package com.kharidlo.service.order.service;

import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderCreationResponse;
import com.kharidlo.service.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderCreationResponse create(Order order){

        long orderId = orderRepository.save(order).getId();
        return new OrderCreationResponse(orderId,"Order has been placed successfully");
    }
}
