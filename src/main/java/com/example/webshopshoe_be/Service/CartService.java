package com.example.webshopshoe_be.Service;


import com.example.webshopshoe_be.Entity.Cart;
import com.example.webshopshoe_be.Entity.User;
import com.example.webshopshoe_be.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart createOrUpdateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
