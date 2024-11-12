package com.example.webshopshoe_be.Controller;


import com.example.webshopshoe_be.Entity.CartItem;
import com.example.webshopshoe_be.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cart/{cartId}")
    public List<CartItem> getCartItemsByCartId(@PathVariable Long cartId) {
        return cartItemService.getCartItemsByCartId(cartId);
    }

    @PostMapping
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.addCartItem(cartItem);
    }

    @PutMapping("/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
        return cartItemService.updateCartItem(id, cartItem);
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
    }
}
