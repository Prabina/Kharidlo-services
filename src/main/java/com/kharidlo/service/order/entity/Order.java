package com.kharidlo.service.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "ORDER")
public class Order {

    private long id;


    private String emailId;


    private double totalPrice;

    private String status;

    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderDetails orderDetails;

}
