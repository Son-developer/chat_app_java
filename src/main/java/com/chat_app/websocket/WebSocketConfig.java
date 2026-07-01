package com.chat_app.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

// khai báo lớp WebSocketConfig để cấu hình WebSocket
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // cấu hình bộ định tuyến tin nhắn
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // bật bộ định tuyến tin nhắn đơn giản với tiền tố "/topic" để gửi tin nhắn đến
        // các client
        config.enableSimpleBroker("/topic");
        // đặt tiền tố "/app" cho các tin nhắn gửi từ client đến server
        config.setApplicationDestinationPrefixes("/app");
    }

    // đăng ký địa chỉ endpoint cho WebSocket
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // đăng ký endpoint "/ws" và cho phép tất cả các nguồn gốc truy cập, đồng thời
        // hỗ trợ SockJS
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}