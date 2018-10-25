package com.kharidlo.service.order.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kharidlo.service.order.model.Order;
import com.kharidlo.service.order.model.OrderCreationResponse;
import com.kharidlo.service.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity<OrderCreationResponse> create(@RequestBody Order order) throws JsonProcessingException {

        Optional<Long> orderId = orderService.create(order);
        OrderCreationResponse response = new OrderCreationResponse();
        if(orderId.isPresent()) {
            response.setOrderId(orderId.get());
            response.setSuccessMessage("Order has been placed successfully.");
            return new ResponseEntity(objectMapper.writeValueAsString(response), HttpStatus.CREATED);
        } else {
            response.setErrorMessage("Order is not completed due to conflict. Please retry.");
            return new ResponseEntity(objectMapper.writeValueAsString(response), HttpStatus.CONFLICT);
        }
    }
}
