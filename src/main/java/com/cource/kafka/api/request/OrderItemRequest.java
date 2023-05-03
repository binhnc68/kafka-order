package com.cource.kafka.api.request;

public class OrderItemRequest {
	private String itemName;
	private int price;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItemRequest [itemName=" + itemName + ", price=" + price + "]";
	}
	
	
}
