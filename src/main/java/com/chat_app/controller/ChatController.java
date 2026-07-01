package com.chat_app.controller;

// XỬ LÝ TIN NHẮN QUA WEBSOCKET
import com.chat_app.model.Message;
import com.chat_app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

// khai báo lớp ChatController để xử lý các yêu cầu liên quan đến trò chuyện
@Controller
public class ChatController {

    // công cụ để gửi tin nhắn đến các client thông qua WebSocket
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // kết nối với cơ sở dữ liệu để lưu trữ tin nhắn
    @Autowired
    private MessageRepository messageRepository;

    // xử lý tin nhắn gửi từ client đến server
    @MessageMapping("/chat")
    // nhận tin nhắn từ client
    public void sendMessage(Message message) {
        // thời gian giửi tin và lưu tin vào dữ liệu
        message.setSentAt(java.time.LocalDateTime.now());
        messageRepository.save(message);
        // gửi tin nhắn đến các client đã đăng ký nhận tin nhắn từ người nhận
        messagingTemplate.convertAndSend(
                "/topic/chat/" + message.getReceiver(), message);
    }
}