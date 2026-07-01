package com.chat_app.controller;

import com.chat_app.model.User;
import com.chat_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// khai báo lớp AuthController để xử lý các yêu cầu liên quan đến xác thực người dùng
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // lấy dữ liệu từ cơ sở
    @Autowired
    private UserRepository userRepository;

    // đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String username) {
        final String name = username.trim();

        // kiểm tra xem user có tồn tại trong cơ sở dữ liệu hay không, nếu không thì tạo
        // mới
        User user = userRepository.findByUsername(name)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUsername(name);
                    return userRepository.save(newUser);
                });

        // đặt trạng thái online của user thành true và lưu lại vào cơ sở dữ liệu
        user.setOnline(true);
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    // đăng xuất
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody String username) {
        final String name = username.trim();
        userRepository.findByUsername(name).ifPresent(user -> {
            user.setOnline(false);
            userRepository.save(user);
        });
        return ResponseEntity.ok("Logged out");
    }
}