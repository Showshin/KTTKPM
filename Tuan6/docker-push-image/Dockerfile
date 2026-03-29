# Stage 1: Cài dependencies dùng alpine để giảm kích thước
FROM node:22-alpine AS builder
WORKDIR /app
COPY package*.json .
# Chỉ cài production dependencies, bỏ qua devDependencies
RUN npm ci --omit=dev

# Stage 2: Runtime image nhỏ gọn
FROM node:22-alpine
WORKDIR /app
# Copy node_modules từ stage builder
COPY --from=builder /app/node_modules ./node_modules
COPY index.mjs .
COPY package.json .
# Chạy với user non-root để tăng bảo mật
USER node
EXPOSE 3000
CMD ["node", "index.mjs"]
