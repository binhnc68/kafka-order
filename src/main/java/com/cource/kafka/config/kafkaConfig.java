package com.cource.kafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class kafkaConfig {

//	@Autowired
//	private KafkaProperties kafkaProperties;

	@Bean
	public NewTopic topicOrder() {
		return TopicBuilder.name("t.commodity.order").partitions(2).replicas(1).build();
	}

}
