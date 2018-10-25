package com.kharidlo.service.product.repository;

import com.kharidlo.service.product.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
    List<ProductCategory> findAll();
}
