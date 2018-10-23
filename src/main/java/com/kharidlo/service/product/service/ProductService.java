package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> search(String searchKey) {
        List<Product> products = productRepository.findByTitleContainsIgnoreCase(searchKey);
        return products;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
