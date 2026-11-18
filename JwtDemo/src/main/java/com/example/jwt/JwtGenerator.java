
package com.example.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;

public class JwtGenerator {

    public static String generateToken(String username) {

        SecretKey key = Keys.hmacShaKeyFor(
            "mySecretKey123456789012345678901234".getBytes()
        );

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(
                    System.currentTimeMillis() + 3600000
                ))
                .signWith(key)
                .compact();

        return token;
    }

    public static void main(String[] args) {

        String token = generateToken("abc");

        System.out.println("Generated JWT Token:");
        System.out.println(token);
    }
}
