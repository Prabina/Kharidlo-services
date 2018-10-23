package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> search(String searchKey) {
        List<Product> products = productRepository.search(searchKey);
        return products;
    }
}
