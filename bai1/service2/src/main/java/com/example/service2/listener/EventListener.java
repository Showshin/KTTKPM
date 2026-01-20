package com.example.service2.listener;

import com.example.service2.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("========================================");
        System.out.println("<<< Service 2: Nhận được message: " + message);
        System.out.println("<<< Service 2: Đang xử lý...");
        System.out.println("<<< Service 2: Xử lý xong!");
        System.out.println("========================================");
    }
}
