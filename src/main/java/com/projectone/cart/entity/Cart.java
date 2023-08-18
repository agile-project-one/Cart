package com.projectone.cart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {


    // generatedValue is used to increment primary key automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    Long cartId;

    @Column(name="product_id")
    Long productId;

    @Column(name="user_id")
    Long userId;

    Long quantity;

}
