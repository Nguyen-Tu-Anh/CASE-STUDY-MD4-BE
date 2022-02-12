package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAllProduct();
    List<Product> findProductByCategory_Id(Long id);
    void save(Product product);
    Product findById(Long id);
    void deleteProduct(Long id);
    
    Page<Product> findAll(Pageable pageable);
    int countProducts();
    List<Product> findAllByNameProductContaining(String nameProduct);

}
