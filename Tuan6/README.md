# Week 06

## Container --> Docker Image

1. Khởi động docker compose với 2 services: MySQL và phpMyAdmin

2. Xem danh sách các container đang chạy

3. Truy cập phpMyAdmin, tạo database và thêm dữ liệu mẫu

4. Tạo Docker image từ container MySQL đang chạy bằng `docker commit`

5. Cập nhật file `docker-compose.yaml` dùng image `mysql-custom` vừa tạo, sau đó chạy lại

## Push Image lên Docker Hub

1. Đăng nhập Docker Hub và tag image, sau đó build image từ Dockerfile multi-stage

2. Đẩy image lên Docker Hub bằng lệnh `docker push`

3. Kiểm tra image đã xuất hiện trên Docker Hub

4. Kết quả chạy ứng dụng với các route `/`, `/about`, `/time`
