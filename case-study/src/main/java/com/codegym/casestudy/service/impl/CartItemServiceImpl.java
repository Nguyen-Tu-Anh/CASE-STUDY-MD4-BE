package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.CartItem;
import com.codegym.casestudy.model.Product;
import com.codegym.casestudy.model.Users;
import com.codegym.casestudy.repository.ICartItemRepository;
import com.codegym.casestudy.service.ICartItemService;
import com.codegym.casestudy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {
    @Autowired
    ICartItemRepository cartItemRepository;

    @Autowired
    IProductService productService;

    @Override
    public List<CartItem> listCartItem(Users users) {
        return cartItemRepository.findCartItemByUsers(users);
    }

    @Override
    public void addProduct(Long productId, double quantity, Users users) {
        double addedQuantity;
        Product product = productService.findById(productId);
        CartItem cartItem = cartItemRepository.findCartItemByUsersAndProduct(users, product);
        if (cartItem != null) {
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
            cartItem.setUsers(users);
        }
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
