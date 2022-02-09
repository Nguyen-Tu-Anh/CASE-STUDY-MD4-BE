package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findProductByCategory_Id(Long id);
    @Query(nativeQuery = true, value = "select count(id) from product")
    int countProducts();
}
