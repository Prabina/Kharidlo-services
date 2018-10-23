package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> search(String searchKey);

    Product create(Product product);
}
