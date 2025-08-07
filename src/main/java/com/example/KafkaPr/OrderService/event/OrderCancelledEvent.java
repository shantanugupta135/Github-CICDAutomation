package com.example.KafkaPr.OrderService.event;

public class OrderCancelledEvent {

	private String orderId;
	private String reason;
	
	
	public OrderCancelledEvent(String orderId, String reason) {
		super();
		this.orderId = orderId;
		this.reason = reason;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "OrderCancelledEvent [orderId=" + orderId + ", reason=" + reason + "]";
	}
	
	
}
