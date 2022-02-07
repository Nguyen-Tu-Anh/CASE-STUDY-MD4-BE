package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
