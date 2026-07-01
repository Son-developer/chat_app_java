# Real-time Chat Application - Java Spring Boot

Dự án ứng dụng chat thời gian thực (Real-time Chat) được xây dựng bằng Java Spring Boot.

## 🛠 Tech Stack
- **Framework:** Spring Boot 3.x
- **Database:** H2 Database (In-memory)
- **Build Tool:** Maven
- **Language:** Java 17+

## hoàn thành (Database & Base Setup)
- Khởi tạo cấu trúc dự án Spring Boot tiêu chuẩn.
- Cấu hình kết nối H2 Database.
- Đã định nghĩa các **Entities (Models):** `User`, `Message`.
- Đã thiết lập **Repositories** để truy vấn dữ liệu.
- Đã cấu hình cơ bản cho **WebSocket**.

## Hướng dẫn chạy dự án
1. **Clone dự án:** `git clone https://github.com/Son-developer/chat_app_java.git`
2. **Chạy ứng dụng:**
   - Mở terminal tại thư mục gốc.
   - Chạy lệnh: `./mvnw clean spring-boot:run`
3. **Truy cập Database:**
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:chatdb`

