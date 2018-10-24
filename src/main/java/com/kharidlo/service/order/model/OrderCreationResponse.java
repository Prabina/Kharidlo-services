package com.kharidlo.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCreationResponse {

    private long orderId;

    private String message;

}
