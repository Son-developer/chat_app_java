package com.chat_app;

// Nhà máy điều phối mọi thứ
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// khai báo lớp ChatAppJavaApplication để chạy ứng dụng Spring Boot
@SpringBootApplication
public class ChatAppJavaApplication {

	// phương thức main để chạy ứng dụng Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(ChatAppJavaApplication.class, args);
	}

}
