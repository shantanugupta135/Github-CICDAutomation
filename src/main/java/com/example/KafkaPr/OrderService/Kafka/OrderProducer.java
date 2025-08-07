package com.example.KafkaPr.OrderService.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.KafkaPr.OrderService.event.OrderCancelledEvent;
import com.example.KafkaPr.OrderService.event.OrderCreatedEvent;

@Component
public class OrderProducer {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void publishOrderEvent(OrderCreatedEvent event) {
		kafkaTemplate.send("order-created", event);
	}
	
	public void publishOrderCancelled(OrderCancelledEvent event) {
		kafkaTemplate.send("order-cancelled", event);
		
	}
}
