package com.cource.kafka.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class Order {

	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;
	
	@Column(nullable = false)
	private LocalDateTime orderDateTime;
	
	@Column(nullable = false)
	private String creditCardnumber;
	
	@Id
	@GeneratedValue
	private int orderId;
	
	@Column(nullable = false)
	private String orderLocation;
	
	@Column(nullable = false)
	private String orderNumber;

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getCreditCardnumber() {
		return creditCardnumber;
	}

	public void setCreditCardnumber(String creditCardnumber) {
		this.creditCardnumber = creditCardnumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + ", orderDateTime=" + orderDateTime + ", creaditCardnumber=" + creditCardnumber
				+ ", orderId=" + orderId + ", orderLocation=" + orderLocation + ", orderNumber=" + orderNumber + "]";
	}
	
	
	
}
