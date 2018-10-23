package com.kharidlo.service.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kharidlo.service.product.controller.ProductController;
import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.service.IFileStorageService;
import com.kharidlo.service.product.service.IProductService;
import com.kharidlo.service.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @MockBean
    private IFileStorageService fileStorageService;

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

    public void shouldCreateProductIfValidProductIsPassed() throws Exception {

        Product product = Product.builder()
                .category("School")
                .description("School bag for kids")
                .features("20 ltrs")
                .imageUrl("testUrl")
                .price(100.00)
                .build();

        when(productService.create(product)).thenReturn(product);

        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(product);

        this.mockMvc.perform(post("/product/create").contentType(MediaType.APPLICATION_JSON).content(productJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUploadProductImage() throws Exception {
        MultipartFile imageObject = new MockMultipartFile("test.jpg",new byte[0]);

        when(fileStorageService.uploadImage(imageObject)).thenReturn("newpath");

        this.mockMvc.perform(post("/product/imageupload").contentType(MediaType.MULTIPART_FORM_DATA).content(new byte[0]))
                .andExpect(status().isOk());
    }
}
