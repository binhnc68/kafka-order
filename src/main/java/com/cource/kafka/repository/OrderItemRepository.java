package com.cource.kafka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cource.kafka.entity.OrderItem;


@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}
