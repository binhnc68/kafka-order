package com.cource.kafka.api.request;

import java.util.List;

public class OrderRequest {

	private String orderLocation;
	private String creditCarNumber;
	private List<OrderItemRequest> items;
	public String getOrderLocation() {
		return orderLocation;
	}
	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}
	public String getCreditCarNumber() {
		return creditCarNumber;
	}
	public void setCreditCarNumber(String creditCarNumber) {
		this.creditCarNumber = creditCarNumber;
	}
	public List<OrderItemRequest> getItems() {
		return items;
	}
	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}
	
	
}
