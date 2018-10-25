package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.ProductCategory;
import com.kharidlo.service.product.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {


    private IProductCategoryRepository iProductCategoryRepository;

    @Autowired
    public ProductCategoryService(IProductCategoryRepository iProductCategoryRepository) {
        this.iProductCategoryRepository = iProductCategoryRepository;
    }

    public List<ProductCategory> getAllProductCategories() {
        return iProductCategoryRepository.findAll();
    }
}
