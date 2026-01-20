package com.example.bai1.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

@Service
public class MessageQueueService {
    
    private final Queue<String> messageQueue = new ConcurrentLinkedQueue<>();
    
    /**
     * Push một message vào queue
     * @param message nội dung message
     * @return true nếu thành công
     */
    public boolean push(String message) {
        return messageQueue.offer(message);
    }
    
    /**
     * Nhận (lấy ra) một message từ queue
     * @return message hoặc null nếu queue rỗng
     */
    public String receive() {
        return messageQueue.poll();
    }
    
    /**
     * Xem message đầu tiên mà không lấy ra khỏi queue
     * @return message hoặc null nếu queue rỗng
     */
    public String peek() {
        return messageQueue.peek();
    }
    
    /**
     * Lấy số lượng message trong queue
     * @return số lượng message
     */
    public int size() {
        return messageQueue.size();
    }
    
    /**
     * Kiểm tra queue có rỗng không
     * @return true nếu queue rỗng
     */
    public boolean isEmpty() {
        return messageQueue.isEmpty();
    }
}
