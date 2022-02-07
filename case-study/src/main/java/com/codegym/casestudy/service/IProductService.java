package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
    List<Product> findProductByCategory_Id(Long id);
    void save(Product product);
    Product findById(Long id);
    void deleteProduct(Long id);
}
