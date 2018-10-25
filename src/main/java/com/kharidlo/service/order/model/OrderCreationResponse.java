package com.kharidlo.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationResponse {

    private long orderId;

    private String successMessage;

    private String errorMessage;

}
