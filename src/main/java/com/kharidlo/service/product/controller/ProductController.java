package com.kharidlo.service.product.controller;

import com.kharidlo.service.product.model.Product;
import com.kharidlo.service.product.service.IFileStorageService;
import com.kharidlo.service.product.service.IProductService;
import com.kharidlo.service.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    IFileStorageService fileStorageService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> get(@RequestParam("searchKey") String searchKey) {

        List<Product> products = productService.search(searchKey);

        if(products == null || products.isEmpty()) {
            return new ResponseEntity("{\"message\":\"Product not found\"}", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public Product create(@RequestBody Product product) {

        return productService.create(product);
    }

    @PostMapping(path = "/imageupload")
    @ResponseBody
    public String create(@RequestBody MultipartFile file) throws FileNotFoundException {
        return fileStorageService.uploadImage(file);
    }


}
