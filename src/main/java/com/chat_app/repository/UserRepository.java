package com.chat_app.repository;

import com.chat_app.model.User;
// chức năng cơ bản của JpaRepository là cung cấp các phương thức CRUD (Create, Read, Update, Delete) và các phương thức truy vấn dữ liệu từ cơ sở dữ liệu. Nó giúp giảm bớt việc viết mã lặp đi lặp lại và tăng tính hiệu quả trong việc quản lý dữ liệu.
import org.springframework.data.jpa.repository.JpaRepository;
// kiểm tra user có tồn tại hoặc không 
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
