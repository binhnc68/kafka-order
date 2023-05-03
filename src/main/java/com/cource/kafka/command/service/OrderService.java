package com.cource.kafka.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cource.kafka.api.request.OrderRequest;
import com.cource.kafka.command.action.OrderAction;
import com.cource.kafka.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderAction action;
	

	public String saveOrder(OrderRequest request) {
		
		// 1. convert OrderRequest to order
		Order order = action.convertToOrder(request);
		// 2. save order to database
		action.saveToDatabase(order);
		
		// 3. 
		order.getItems().forEach(action::publishToKafka);
		return order.getOrderNumber();
	}
}
