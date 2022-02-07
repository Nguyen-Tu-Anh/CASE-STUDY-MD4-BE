package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> showProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findProductByCategory_Id(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findById(@PathVariable Long id) {
//        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
