package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Category;
import com.codegym.casestudy.repository.CategoryRepo;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
