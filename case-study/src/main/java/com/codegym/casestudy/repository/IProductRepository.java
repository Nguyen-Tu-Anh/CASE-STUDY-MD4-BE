package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findProductByCategory_Id(Long id);
}
