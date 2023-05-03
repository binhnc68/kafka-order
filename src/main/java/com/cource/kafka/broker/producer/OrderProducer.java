package com.cource.kafka.broker.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.cource.kafka.broker.message.OrderMessage;

@Service
public class OrderProducer {

	private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	public void publish(OrderMessage message) {

		
		// send topic order
		ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("t.commdity.order", message.getOrderNumber(), message);
		
		future.addCallback(null, new ListenableFutureCallback<SendResult<String, OrderMessage>>() {

			@Override
			public void onSuccess(SendResult<String, OrderMessage> result) {
				log.info("OrderProducer.publish - sent  successfuly ,Order= {} ,item={} ", message.getOrderNumber(),
						message.getItemName());

			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("OrderProducer.publish - unable to send Order= {} ,item={} , because={} ", message.getOrderNumber(), message.getItemName(), ex.getMessage());

			}
			
		});
		
		log.info("OrderProducer.publish - sent  successfuly ,Order= {} ,item={} ", message.getOrderNumber(),
				message.getItemName());

	}
}
