package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Category;
import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.model.Users;
import com.codegym.casestudy.security.jwt.JwtProvider;
import com.codegym.casestudy.service.ICategoryService;
import com.codegym.casestudy.service.IProductService;
import com.codegym.casestudy.service.IRoleService;
import com.codegym.casestudy.service.IUserService;
import com.codegym.casestudy.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductControllerCrud {
    @Autowired
    IProductService productService;

    @Autowired
    IRoleService roleService;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Product>> show(@RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(productService.findAll(PageRequest.of(page, 3)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }


    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/countProducts")
    public int countUsers() {
        return productService.countProducts();
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/search/{nameProduct}")
    public ResponseEntity<?> findAllByNameProduct(@PathVariable String nameProduct){
        return new ResponseEntity<>(productService.findAllByNameProductContaining(nameProduct),HttpStatus.OK);
    }
}
