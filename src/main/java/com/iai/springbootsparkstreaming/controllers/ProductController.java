package com.iai.springbootsparkstreaming.controllers;

import com.iai.springbootsparkstreaming.model.Product;
import com.iai.springbootsparkstreaming.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return service.findAll();
    }
}
