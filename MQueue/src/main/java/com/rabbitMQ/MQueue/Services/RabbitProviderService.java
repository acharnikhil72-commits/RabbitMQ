package com.rabbitMQ.MQueue.Services;

import org.springframework.stereotype.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service 
public class RabbitProviderService {


    public RabbitTemplate rabbitTemplate;


    public RabbitProviderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value ("${rabbitmq.routing.key}")
    private String routingKey;  
    @Value ("${rabbitmq.queue.name}")
    private String queueName;  
    
    
    public String ExchangeName() {
        return exchangeName;
    }

    public String RoutingKey() {
        return routingKey;
    }

    public String QueueName() {
        return queueName;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(RabbitProviderService.class);

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));

        
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }


}
