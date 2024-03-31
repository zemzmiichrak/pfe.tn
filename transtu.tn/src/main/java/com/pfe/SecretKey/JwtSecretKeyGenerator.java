package com.pfe.SecretKey;

import java.util.Base64;

import javax.crypto.SecretKey;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtSecretKeyGenerator {
    public static void main(String[] args) {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        System.out.println("Clé secrète générée : " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
    }
}