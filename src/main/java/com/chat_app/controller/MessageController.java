package com.chat_app.controller;

import com.chat_app.model.Message;
import com.chat_app.repository.MessageRepository;
import com.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// khai báo lớp MessageController để xử lý các yêu cầu liên quan đến tin nhắn
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    // lấy dữ liệu từ cơ sở
    @Autowired
    private MessageRepository messageRepository;

    // lấy tất cả tin nhắn
    @Autowired
    private UserRepository userRepository;

    // lưu trữ tin nhắn mới và gửi lại tin nhắn đã lưu trữ
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        message.setSentAt(java.time.LocalDateTime.now());
        return ResponseEntity.ok(messageRepository.save(message));
    }

    // hàm lấy hội thoại giữ 2 người dùng
    @GetMapping("/conversation")
    public ResponseEntity<?> getConversation(
            // lấy tham số
            @RequestParam String user1,
            @RequestParam String user2) {
        // gọi phương thức fC từ mR để lấy danh sách tin nhắn giữa 2 người
        List<Message> messages = messageRepository.findConversation(user1, user2);
        return ResponseEntity.ok(messages);
    }

    // hàm lấy tất cả người dùng
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
