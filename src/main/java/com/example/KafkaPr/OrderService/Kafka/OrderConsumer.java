package com.example.KafkaPr.OrderService.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.KafkaPr.OrderService.event.OrderCreatedEvent;

@Service
public class OrderConsumer {

	@KafkaListener(topics="inventory-success", groupId = "payment-group")
	public void handleOrderSuccess(OrderCreatedEvent event) {
		System.out.println("Order is successfull" + event.getOrderId());
	}
	
	@KafkaListener(topics="payment-success", groupId = "payment-group")
	public void handlePaymentSuccess(OrderCreatedEvent event) {
		System.out.println("Order is successfull" + event.getOrderId());
	}
}
