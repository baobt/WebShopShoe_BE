package com.example.webshopshoe_be.Repository;


import com.example.webshopshoe_be.Entity.Order;
import com.example.webshopshoe_be.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}