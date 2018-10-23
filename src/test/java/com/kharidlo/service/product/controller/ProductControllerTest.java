package com.kharidlo.service.product.controller;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldReturnListOfProductsWhenSearchedByTitle() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().id(1).build());
        when(productService.search(Mockito.anyString())).thenReturn(productList);
        this.mockMvc.perform(get("/product").param("searchKey", "impedit"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotFoundWhenSearchedByTitleIsNotAvailable() throws Exception {
        List<Product> productList = new ArrayList<>();
        when(productService.search(Mockito.anyString())).thenReturn(productList);
        this.mockMvc.perform(get("/product").param("searchKey", "afrin"))
                .andExpect(status().isNotFound());
    }
}
