package com.kharidlo.service.product.service;


import com.kharidlo.service.product.model.ProductCategory;
import com.kharidlo.service.product.repository.IProductCategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductCategoryServiceTest {

    @Test
    public void shouldReturnListOfProductCategories() throws Exception {

        IProductCategoryRepository iProductCategoryRepository = mock(IProductCategoryRepository.class);
        List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
        productCategories.add(new ProductCategory());
        when(iProductCategoryRepository.findAll()).thenReturn(productCategories);
        ProductCategoryService productCategoryService = new ProductCategoryService(iProductCategoryRepository);

        List<ProductCategory> categoriesList = productCategoryService.getAllProductCategories();

        assertEquals(1, categoriesList.size());

    }

}
