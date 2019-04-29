package com.iai.springbootsparkstreaming.bootstrap;

import com.iai.springbootsparkstreaming.model.Product;
import com.iai.springbootsparkstreaming.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Component("filler")
public class DBFiller {
    @Autowired
    private ProductService service;

//    @EventListener(ContextRefreshedEvent.class)
    @PostConstruct
    public void fillDB() {
        service.saveProduct(Product.builder().name("Cheese").price(10).build());
        service.saveProduct(Product.builder().name("butter").price(10).build());
        service.saveProduct(Product.builder().name("Martini").price(100).build());
        service.saveProduct(Product.builder().name("Meet").price(60).build());
        service.saveProduct(Product.builder().name("Vodka").price(45).build());
        service.saveProduct(Product.builder().name("Tea").price(8).build());
        service.saveProduct(Product.builder().name("coffee").price(6).build());
        service.saveProduct(Product.builder().name("bean").price(6).build());
        service.saveProduct(Product.builder().name("bread").price(6).build());
        service.saveProduct(Product.builder().name("milk").price(2).build());
    }
}
