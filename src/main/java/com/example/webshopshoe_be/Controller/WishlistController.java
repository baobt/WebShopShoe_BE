package com.example.webshopshoe_be.Controller;


import com.example.webshopshoe_be.Entity.Wishlist;
import com.example.webshopshoe_be.Service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping
    public List<Wishlist> getAllWishlistItems() {
        return wishlistService.getAllWishlistItems();
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistItemsByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistItemsByUserId(userId);
    }

    @PostMapping
    public Wishlist addWishlistItem(@RequestBody Wishlist wishlist) {
        return wishlistService.addWishlistItem(wishlist);
    }

    @DeleteMapping("/{id}")
    public void deleteWishlistItem(@PathVariable Long id) {
        wishlistService.deleteWishlistItem(id);
    }
}
