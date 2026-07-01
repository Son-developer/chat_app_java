package com.chat_app.repository;

import com.chat_app.model.Message;
// chức năng cơ bản
import org.springframework.data.jpa.repository.JpaRepository;
// kiểm tra user có tồn tại hoặc không
import org.springframework.data.jpa.repository.Query;
// đặt tên các user để tìm kiếm các tin nhắn giữa hai user
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE " +
            "(m.sender = :user1 AND m.receiver = :user2) OR " +
            "(m.sender = :user2 AND m.receiver = :user1) " +
            "ORDER BY m.sentAt ASC")
    List<Message> findConversation(@Param("user1") String user1,
            @Param("user2") String user2);
}
