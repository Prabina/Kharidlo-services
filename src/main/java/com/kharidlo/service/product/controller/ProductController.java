package com.kharidlo.service.product.controller;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping(path = "/search")
    @ResponseBody
    public List<Product> search(@RequestParam String searchKey) {

        return productService.search(searchKey);
    }
}
