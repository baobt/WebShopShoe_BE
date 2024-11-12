package com.example.webshopshoe_be.Controller;


import com.example.webshopshoe_be.Entity.OrderItem;
import com.example.webshopshoe_be.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    @PostMapping
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.addOrderItem(orderItem);
    }

    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(id, orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}
