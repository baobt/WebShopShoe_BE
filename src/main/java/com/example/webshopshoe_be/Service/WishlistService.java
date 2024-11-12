package com.example.webshopshoe_be.Service;


import com.example.webshopshoe_be.Entity.Wishlist;
import com.example.webshopshoe_be.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<Wishlist> getAllWishlistItems() {
        return wishlistRepository.findAll();
    }

    public List<Wishlist> getWishlistItemsByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addWishlistItem(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void deleteWishlistItem(Long id) {
        wishlistRepository.deleteById(id);
    }
}