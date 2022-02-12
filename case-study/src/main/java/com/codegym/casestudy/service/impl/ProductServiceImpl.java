package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.repository.IProductRepository;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> findProductByCategory_Id(Long id) {
        return productRepository.findProductByCategory_Id(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    @Override
    public int countProducts() {
        return productRepository.countProducts();
    }

    @Override
    public List<Product> findAllByNameProductContaining(String nameProduct) {
        return productRepository.findAllByNameProductContaining(nameProduct);
    }
}
