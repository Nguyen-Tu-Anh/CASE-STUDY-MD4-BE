package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.CartItem;
import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemByUsers(Users users);
    CartItem findCartItemByUsersAndProduct(Users users, Product product);

    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE c.product.id = ?2 and c.users.id = ?3")
    @Modifying
    void updateQuantity(double quantity, Long productId, Long userId);

    @Query("DELETE from CartItem c WHERE c.product.id = ?1 and c.users.id = ?2")
    @Modifying
    void deleteCartItemLessThanZero(Long productId, Long userId);
}
