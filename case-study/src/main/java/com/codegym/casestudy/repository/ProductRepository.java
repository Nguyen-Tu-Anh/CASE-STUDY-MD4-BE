package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select count(id) from product")
    int countProducts();
}
