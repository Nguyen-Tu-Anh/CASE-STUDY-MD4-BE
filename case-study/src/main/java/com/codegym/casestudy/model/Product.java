package com.codegym.casestudy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "product", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nameProduct"
        })
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    private String nameProduct;

    private double price;

    private double quantity;

    @Lob
    private String description;

    @Lob
    private String image;

    @ManyToOne
    private Category category;
}
