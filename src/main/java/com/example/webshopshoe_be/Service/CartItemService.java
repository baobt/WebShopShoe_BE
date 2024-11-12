package com.example.webshopshoe_be.Service;


import com.example.webshopshoe_be.Entity.CartItem;
import com.example.webshopshoe_be.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByCartId(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItem updatedCartItem) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItem.setQuantity(updatedCartItem.getQuantity());
        cartItem.setPrice(updatedCartItem.getPrice());
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
