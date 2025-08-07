package com.example.KafkaPr.OrderService.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.KafkaPr.OrderService.model.Order;
import com.example.KafkaPr.OrderService.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order create(@RequestParam String productId, @RequestParam int quantity) {
        return service.createOrder(productId, quantity);
    }

    @PostMapping("/cancel")
    public String cancel(@RequestParam String orderId, @RequestParam String reason) {
        service.cancelOrder(orderId, reason);
        return "Cancelled";
    }
    
    @GetMapping("/hello")
    public String getGreeting( ) {
    	return "Hello";
    }
}