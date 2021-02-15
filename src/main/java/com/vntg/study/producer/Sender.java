package com.vntg.study.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Sender {
	@Autowired
	RabbitTemplate template;
	
	private static final String topicExchange = "spring-boot-exchange";
	
	
	public void send(String message) {
		 CustomMessage cMess = new CustomMessage(message, 1, true);
		 template.convertAndSend(topicExchange, "sample.oingdaddy.#", cMess);
	}
}
