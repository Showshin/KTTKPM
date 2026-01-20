package com.example.service1.service;

import com.example.service1.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void pushMessage(String message) {
        System.out.println(">>> Service 1: Đang gửi message: " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println(">>> Service 1: Đã gửi thành công!");
    }
}
