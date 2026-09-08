package com.rabbitMQ.MQueue.Config;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration 
public class RabbitConfig {

    @Value ("${rabbitmq.queue.name}")
    private String queueName;


    @Value ("${rabbitmq.exchange.name}")
    private String exchangeName;    



    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    @Bean 
    public Queue queueName() {
        return new Queue(queueName);
    }   

    @Bean 
    public DirectExchange exchangeName() {
        return new DirectExchange(exchangeName);
    }
    

    @Bean 
    public  String routingKey() {
        return routingKey;
    }


    @Bean 
    public Binding Builder() {
        return BindingBuilder.
                            bind(queueName())
                            .to(exchangeName())
                            .with(routingKey());
    }



    // connectionfactory
    // Rabbittemplte                    // this 3 were created automatically by springboot when we add the dependency of rabbitmq
    // rabbitAdmin


    

}
