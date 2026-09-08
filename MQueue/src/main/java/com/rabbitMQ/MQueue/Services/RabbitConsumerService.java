package com.rabbitMQ.MQueue.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(RabbitConsumerService.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(String message) {
        LOGGER.info(String.format("Message received -> %s", message));

        // process the message here
        // e.g. parse JSON, save to DB, trigger auth logic, etc.
    }
}
