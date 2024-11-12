package com.example.webshopshoe_be.Repository;

import com.example.webshopshoe_be.Entity.Cart;
import com.example.webshopshoe_be.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}