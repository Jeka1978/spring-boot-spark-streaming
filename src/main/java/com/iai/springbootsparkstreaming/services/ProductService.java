package com.iai.springbootsparkstreaming.services;

import com.iai.springbootsparkstreaming.dao.ProductDao;
import com.iai.springbootsparkstreaming.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class ProductService implements Serializable {
    @Autowired
    private ProductDao dao;

    public void saveProduct(Product product) {
        dao.save(product);
    }

    public List<Product> findAll() {
        return dao.findAll();
    }

    public Product getById(long id) {
        return dao.findById(id).orElse(Product.builder().id(1000).name("Kola").build());
    }
}
