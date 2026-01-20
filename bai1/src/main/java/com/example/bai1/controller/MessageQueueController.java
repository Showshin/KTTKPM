package com.example.bai1.controller;

import com.example.bai1.service.MessageQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/queue")
public class MessageQueueController {
    
    @Autowired
    private MessageQueueService messageQueueService;
    
    /**
     * Push một message vào queue
     * POST /api/queue/push
     * Body: { "message": "nội dung message" }
     */
    @PostMapping("/push")
    public ResponseEntity<Map<String, Object>> pushMessage(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        
        if (message == null || message.isEmpty()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Message không được để trống");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        boolean result = messageQueueService.push(message);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", result);
        response.put("message", "Đã push message vào queue");
        response.put("queueSize", messageQueueService.size());
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Nhận (lấy ra) một message từ queue
     * GET /api/queue/receive
     */
    @GetMapping("/receive")
    public ResponseEntity<Map<String, Object>> receiveMessage() {
        String message = messageQueueService.receive();
        
        Map<String, Object> response = new HashMap<>();
        
        if (message == null) {
            response.put("success", false);
            response.put("message", "Queue đang rỗng, không có message nào");
            response.put("queueSize", 0);
        } else {
            response.put("success", true);
            response.put("message", message);
            response.put("queueSize", messageQueueService.size());
        }
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Xem trạng thái queue
     * GET /api/queue/status
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getQueueStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("size", messageQueueService.size());
        response.put("isEmpty", messageQueueService.isEmpty());
        response.put("nextMessage", messageQueueService.peek());
        
        return ResponseEntity.ok(response);
    }
}
