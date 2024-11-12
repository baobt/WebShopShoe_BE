package com.example.webshopshoe_be.Service;


import com.example.webshopshoe_be.Entity.Order;
import com.example.webshopshoe_be.Entity.User;
import com.example.webshopshoe_be.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
