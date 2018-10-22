package com.kharidlo.service.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Features")
    private String features;

    @Column(name = "Category")
    private String category;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    public Product() {
    }


}
