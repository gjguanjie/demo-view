package com.cloud.consumer;

import com.alibaba.fastjson.JSON;
import com.cloud.configuration.RabbitConstants;
import com.cloud.entity.OrderMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConstants.MSG_QUEUE)
public class RabbitConsumerListener implements ChannelAwareMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConsumerListener.class);
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
            String msg = new String(message.getBody());
            LOGGER.error("提取消息,{}",msg);
            OrderMessage orderMessage = JSON.parseObject(msg,OrderMessage.class);
            if (orderMessage.getOrderTitle().equals("测试数据10")) {
                throw new RuntimeException("异常");
            }
            // 确认消费消息
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            // 重新放入队列
            channel.basicReject(deliveryTag, true);
            //channel.basicNack(deliveryTag,true,true);
        }

    }
}
