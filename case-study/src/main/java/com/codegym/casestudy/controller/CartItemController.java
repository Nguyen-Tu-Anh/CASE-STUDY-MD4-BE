package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.CartItem;
import com.codegym.casestudy.model.Users;
import com.codegym.casestudy.security.userprinciple.UserPrinciple;
import com.codegym.casestudy.service.ICartItemService;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    IUserService userService;

    @Autowired
    ICartItemService cartItemService;

    @GetMapping("/list")
    public ResponseEntity<?> showCartItem(@AuthenticationPrincipal UserPrinciple userPrinciple) {
        Users users = userService.findByUserName(userPrinciple.getUsername()).get();
        List<CartItem> cartItemList = cartItemService.listCartItem(users);
        return new ResponseEntity<>(cartItemList, HttpStatus.OK);
    }

    @PostMapping("/add/{pid}")
    public ResponseEntity<?> addProductToCart(@PathVariable("pid") Long productId, @AuthenticationPrincipal UserPrinciple userPrinciple) {
        double quantity = 1;
        Users users = userService.findByUserName(userPrinciple.getUsername()).get();
        cartItemService.addProduct(productId, quantity, users);
        return showCartItem(userPrinciple);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/update/{pid}/{quantity}")
    public ResponseEntity<?> updateProductQuantity(@PathVariable("quantity") double quantity,
                                                   @PathVariable("pid") Long productId,
                                                   @AuthenticationPrincipal UserPrinciple userPrinciple) {
        Users users = userService.findByUserName(userPrinciple.getUsername()).get();
        if (quantity > 0) {
            cartItemService.updateQuantity(quantity, productId, users.getId());
            return showCartItem(userPrinciple);
        } else {
            cartItemService.deleteCartItemLessThanZero(productId, users);
            return showCartItem(userPrinciple);
        }
    }
}
