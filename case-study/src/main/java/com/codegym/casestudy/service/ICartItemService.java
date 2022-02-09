package com.codegym.casestudy.service;

import com.codegym.casestudy.model.CartItem;
import com.codegym.casestudy.model.Users;

import java.util.List;

public interface ICartItemService {
    List<CartItem> listCartItem (Users users);
    void addProduct(Long productId, double quantity, Users users);
    void deleteCartItem(Long id);
    void updateQuantity(double quantity, Long productId, Long userId);
    void deleteCartItemLessThanZero(Long productId, Users users);
}
