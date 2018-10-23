package com.kharidlo.service.product.service;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.repository.IProductRepository;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Test
    public void shouldCreateProductIfValidProductInformationPassed(){

        Product product = Product.builder()
                .category("School")
                .description("School bag for kids")
                .features("20 ltrs")
                .imageUrl("testUrl")
                .price(100.00)
                .build();

        IProductRepository productRepository = mock(IProductRepository.class);

        IProductService productService = new ProductService(productRepository);

        when(productRepository.save(product)).thenReturn(product);

        Product resultProduct = productService.create(product);

        assertNotNull(resultProduct);

    }
}