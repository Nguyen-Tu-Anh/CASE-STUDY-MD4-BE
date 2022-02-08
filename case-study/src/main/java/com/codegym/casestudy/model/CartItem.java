package com.codegym.casestudy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private double quantity;

    @Transient
    public double getSubtotal() {
        return this.product.getPrice() * quantity;
    }
}
