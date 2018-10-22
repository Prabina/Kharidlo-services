package com.kharidlo.service.product;

import com.kharidlo.service.product.controller.ProductController;
import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class productControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldReturnListOfProductsWhenSearchedByTitle() throws Exception {
        List<Product> productList = new ArrayList<>();
        when(productService.search("shirt")).thenReturn(productList);
        this.mockMvc.perform(post("/product/search").param("searchKey", "shirt"))
                .andExpect(status().isOk());
    }
}
