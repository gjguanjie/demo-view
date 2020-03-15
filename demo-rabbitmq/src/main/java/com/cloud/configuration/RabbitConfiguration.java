package com.cloud.configuration;

import com.cloud.consumer.RabbitConsumerListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue msgQueue() {
        return new Queue(RabbitConstants.MSG_QUEUE,true);
    }

    @Bean
    public DirectExchange msgExchange(){
        return new DirectExchange(RabbitConstants.MSG_EXCHANGE);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(msgQueue()).to(msgExchange()).with(RabbitConstants.MSG_ROUTING_KEY);
    }

    @Resource
    private CachingConnectionFactory connectionFactory;

    @Resource
    private RabbitConsumerListener rabbitConsumerListener;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(10);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueueNames(RabbitConstants.MSG_QUEUE);
        container.setMessageListener(rabbitConsumerListener);
        return container;
    }
}
