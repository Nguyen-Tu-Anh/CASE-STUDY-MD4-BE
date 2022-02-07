package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Category;
import com.codegym.casestudy.repository.ICategoryRepository;
import com.codegym.casestudy.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }
}
