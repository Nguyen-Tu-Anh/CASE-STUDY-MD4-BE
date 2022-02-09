package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
    int countProducts();
    Product save(Product product);
    void deleteById(Long id);
}
