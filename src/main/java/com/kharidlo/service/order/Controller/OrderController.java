package com.kharidlo.service.order.Controller;

import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderCreationResponse;
import com.kharidlo.service.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @PostMapping
    @ResponseBody
    public OrderCreationResponse create(@RequestBody Order order) {

       return orderService.create(order);
    }
}
