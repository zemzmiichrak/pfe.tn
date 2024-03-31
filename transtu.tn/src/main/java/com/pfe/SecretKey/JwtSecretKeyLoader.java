package com.pfe.SecretKey;

import javax.crypto.SecretKey;

import io.jsonwebtoken.security.Keys;

public class JwtSecretKeyLoader {
    public static SecretKey loadSecretKey() {
        String secretKeyStr = System.getenv("JWT_SECRET_KEY");
        if (secretKeyStr == null || secretKeyStr.isEmpty()) {
            throw new RuntimeException("La clé secrète JWT n'est pas configurée.");
        }
        return Keys.hmacShaKeyFor(secretKeyStr.getBytes());
    }
}