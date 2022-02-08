package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.CartItem;
import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemByUsers(Users users);
    CartItem findCartItemByUsersAndProduct(Users users, Product product);
}
