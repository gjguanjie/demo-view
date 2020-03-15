package com.cloud.producer;

import com.alibaba.fastjson.JSON;
import com.cloud.configuration.RabbitConstants;
import com.cloud.entity.OrderMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class RabbitProducer implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback{

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    public void produce(OrderMessage orderMessage) {
        String msg = JSON.toJSONString(orderMessage);
        rabbitTemplate.convertAndSend(RabbitConstants.MSG_EXCHANGE,RabbitConstants.MSG_ROUTING_KEY,msg);
        // 此处可以将消息持久化到DB
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("confirm--:correlationData:"+correlationData+",ack:"+ack+",cause:"+cause);
        //当消息成功发送至队列时，可以删除消息
        //当消息失败时，可以从DB中重新取出消息，重新发送至队列，注意使用异步方式，提供效率
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        //当消息成功发送至队列时，可以删除消息
        //当消息失败时，可以从DB中重新取出消息，重新发送至队列，注意使用异步方式，提供效率
    }
}
