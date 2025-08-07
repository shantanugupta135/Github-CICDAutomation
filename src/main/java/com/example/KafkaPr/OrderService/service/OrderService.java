package com.example.KafkaPr.OrderService.service;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.KafkaPr.OrderService.Kafka.OrderProducer;
import com.example.KafkaPr.OrderService.event.OrderCancelledEvent;
import com.example.KafkaPr.OrderService.event.OrderCreatedEvent;
import com.example.KafkaPr.OrderService.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderProducer producer;
	
	public Order createOrder(String productId, int quantity) {
		String orderId = Uuid.randomUuid().toString();
	     Order order = new Order();
	     order.setOrderId(orderId);
	     order.setProductId(productId);
	     order.setQuantity(quantity);
	     order.setStatus("Created");
	     
	     producer.publishOrderEvent(new OrderCreatedEvent(orderId, productId, quantity));
	     return order;
	     
	}
	
	public void cancelOrder(String productId, String reason) {
		producer.publishOrderCancelled(new OrderCancelledEvent(productId, reason));
	}
}
