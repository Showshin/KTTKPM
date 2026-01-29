package com.example.service1.controller;

import com.example.service1.service.EventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventProducerService producerService;

    @PostMapping("/push")
    public String pushMessage(@RequestBody String message) {
        producerService.pushMessage(message);
        return "Đã gửi message: " + message;
    }
}
