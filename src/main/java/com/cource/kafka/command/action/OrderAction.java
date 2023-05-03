package com.cource.kafka.command.action;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cource.kafka.api.request.OrderRequest;
import com.cource.kafka.api.response.OrderResponse;
import com.cource.kafka.broker.producer.OrderProducer;
import com.cource.kafka.entity.Order;
import com.cource.kafka.entity.OrderItem;
import com.cource.kafka.repository.OrderItemRepository;
import com.cource.kafka.repository.OrderRepository;
import org.apache.commons.lang3.RandomStringUtils;
import  com.cource.kafka.broker.message.OrderMessage;


import net.bytebuddy.utility.RandomString;

@Component
public class OrderAction {

	@Autowired
	private OrderProducer producer;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public Order convertToOrder(OrderRequest request) {
		Order result = new Order();
		
		result.setCreditCardnumber(request.getCreditCarNumber());
		result.setOrderLocation(request.getOrderLocation());
		result.setOrderDateTime(LocalDateTime.now());
		result.setOrderNumber(RandomStringUtils.randomAlphabetic(8).toUpperCase());
		return result;
	}

	public void saveToDatabase(Order order) {
		orderRepository.save(order);
		order.getItems().forEach(orderItemRepository::save);
	}
	
	public void publishToKafka(OrderItem orderItem) {
		OrderMessage orderMessage = new OrderMessage();
		orderMessage.setItemName(orderItem.getItemName());
		orderMessage.setPrice(orderItem.getPrice());
		orderMessage.setQuantity(orderItem.getQuantity());
		
		orderMessage.setOrderDateTime(orderItem.getOrder().getOrderDateTime());
		orderMessage.setOrderLocation(orderItem.getOrder().getOrderLocation());
		orderMessage.setOrderNumber(orderItem.getOrder().getOrderNumber());
		orderMessage.setCreditCardNumber(orderItem.getOrder().getCreditCardnumber());
		
		producer.publish(orderMessage);
		
		
	}
	
	
	
}
