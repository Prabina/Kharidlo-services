package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public List<Product> search(String searchKey) {

        List<Product> products = new ArrayList<>();
        Iterator<Product> iterator = productRepository.findAll().iterator();
        while (iterator.hasNext()) {
            products.add(iterator.next());

        }
        return products;
    }
}
