package com.kharidlo.service.order.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_TAB")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;

    @Column(name = "EMAIL_ID")
    private String emailId;


    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "STATUS")
    private String status;


    @Column(name = "ORDER_ADDRESS")
    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderedItem> items;

    public Order(String emailId, double totalPrice, String status, String address, List<OrderedItem> items) {
        this.emailId = emailId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.address = address;
        this.items = items;
    }

}
