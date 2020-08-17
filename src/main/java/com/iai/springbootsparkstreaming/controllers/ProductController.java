package com.iai.springbootsparkstreaming.controllers;

import com.iai.springbootsparkstreaming.dao.ProductDao;
import com.iai.springbootsparkstreaming.model.Product;
import com.iai.springbootsparkstreaming.spark.ProductDatasetCache;
import com.iai.springbootsparkstreaming.spark.services.EtlService;
import lab1.model.Item;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ProductController {
    @Autowired
    private SparkSession sparkSession;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductDatasetCache productDatasetCache;

    @Autowired
    private EtlService etlService;

    @GetMapping("/item/refresh")
    @PostConstruct
    public void refreshCache() {
        productDatasetCache.refreshCache(productDao.findAll());
    }

    @GetMapping("/changename")
    public String changeName() {
        etlService.changeName("Petya");
        return "OK";
    }

    @GetMapping("/item/all")
    public List<Product> getAllItems() {
        return productDao.findAll();
    }}
