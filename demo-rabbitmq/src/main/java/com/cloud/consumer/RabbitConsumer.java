package com.cloud.consumer;

import com.alibaba.fastjson.JSON;
import com.cloud.configuration.RabbitConstants;
import com.cloud.entity.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
//@RabbitListener(queues = RabbitConstants.MSG_QUEUE)
public class RabbitConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConsumer.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    //  监听获取消息
    public void consume(String msg) {
        OrderMessage orderMessage = JSON.parseObject(msg, OrderMessage.class);
        LOGGER.info(orderMessage.getOrderTitle());
        if (orderMessage.getOrderTitle().equals("测试数据10")) {
            throw new RuntimeException("异常");
        }
    }

    // 手动获取消息
    public void consume() {
        LOGGER.error("消息消息开始");
        String msgStr = (String) rabbitTemplate.receiveAndConvert(RabbitConstants.MSG_QUEUE);
        OrderMessage orderMessage = JSON.parseObject(msgStr, OrderMessage.class);
        LOGGER.info(orderMessage.getOrderTitle());
        if (orderMessage.getOrderTitle().equals("测试数据2")) {
            throw new RuntimeException("异常");
        }
        LOGGER.error("消息消息结束");
    }


}
