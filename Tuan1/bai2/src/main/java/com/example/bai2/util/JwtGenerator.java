package com.example.bai2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {

    public static void main(String[] args) throws Exception {
        // Đọc private key
        String privateKeyPath = "src/main/resources/private.pem";
        PrivateKey privateKey = loadPrivateKey(privateKeyPath);

        // Tạo JWT token
        long now = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject("user123")
                .setIssuer("bai2-app")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 3600000)) // 1 giờ
                .claim("name", "Nguyen Van A")
                .claim("role", "USER")
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();

        System.out.println("=== JWT TOKEN ===");
        System.out.println(token);
        System.out.println("=================");
        System.out.println("\nSử dụng token:");
        System.out.println("curl -H \"Authorization: Bearer " + token + "\" http://localhost:8080/api/protected/data");
    }

    private static PrivateKey loadPrivateKey(String path) throws Exception {
        String key = new String(Files.readAllBytes(Paths.get(path)));
        key = key.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
