package com.projectone.cart.controller;

import com.projectone.cart.entity.Cart;
import com.projectone.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToWishlist(@RequestBody Cart cart){
        Cart cartItem = cartService.addToCart(cart);
        return ResponseEntity.ok(cartItem);  //200 status code
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart(){
        List<Cart> carts = cartService.getAllCart();
        return ResponseEntity.ok(carts);
    }


    @DeleteMapping("/{cartId}")
    public ResponseEntity<Cart> deleteCartById(@PathVariable("cartId") Long cartId){
        Cart cart= cartService.deleteCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCartById(@PathVariable("cartId") Long cartId, @RequestBody Cart cartFromClient){
        Cart cart = cartService.updateCartById(cartId, cartFromClient);
        return ResponseEntity.ok(cart);
    }

}
