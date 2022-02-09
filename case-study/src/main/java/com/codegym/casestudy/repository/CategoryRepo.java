package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
