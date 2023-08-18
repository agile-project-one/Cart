package com.projectone.cart.service;

import com.projectone.cart.entity.Cart;
import com.projectone.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }

    public Cart deleteCartById(Long cartId){
        Cart cart= cartRepository.findById(cartId).get();
        cartRepository.delete(cart);
        return cart;
    }

    public Cart updateCartById(Long cartId, Cart cartFromClient){
        Cart cart= cartRepository.findById(cartId).get();
        cart.setProductId(cartFromClient.getProductId());
        cart.setUserId(cartFromClient.getUserId());
        cart.setQuantity(cartFromClient.getQuantity());
        cartRepository.save(cart);
        return cart;
    }
}
