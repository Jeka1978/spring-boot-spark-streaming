package com.iai.springbootsparkstreaming.dao;

import com.iai.springbootsparkstreaming.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evgeny Borisov
 */
public interface ProductDao extends JpaRepository<Product,Long> {
}
