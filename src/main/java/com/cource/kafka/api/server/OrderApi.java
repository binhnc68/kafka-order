package com.cource.kafka.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cource.kafka.api.request.OrderRequest;
import com.cource.kafka.api.response.OrderResponse;
import com.cource.kafka.command.service.OrderService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api/order")
public class OrderApi {
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
		
		//1. save order using service
		String orderNumber = orderService.saveOrder(request);
		
		// 2. create response
		OrderResponse  orderResponse = new OrderResponse(orderNumber);
		
		// 3. return 
		return ResponseEntity.ok().body(orderResponse);
	}
}
