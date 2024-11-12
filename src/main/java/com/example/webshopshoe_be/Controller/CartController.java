package com.example.webshopshoe_be.Controller;


import com.example.webshopshoe_be.Entity.Cart;
import com.example.webshopshoe_be.Entity.User;
import com.example.webshopshoe_be.Service.CartService;
import com.example.webshopshoe_be.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public Cart getCartByUserId(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return cartService.getCartByUser(user);
    }

    @PostMapping
    public Cart createOrUpdateCart(@RequestBody Cart cart) {
        return cartService.createOrUpdateCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
