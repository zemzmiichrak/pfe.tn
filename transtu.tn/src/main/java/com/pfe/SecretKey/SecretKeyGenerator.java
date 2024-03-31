package com.pfe.SecretKey;

import java.util.UUID;



public class SecretKeyGenerator {

    public static void main(String[] args) {
        String jwtSecretKey = generateJwtSecretKey();
        System.out.println("JWT Secret Key: " + jwtSecretKey);
    }

    public static String generateJwtSecretKey() {
      
        UUID uuid = UUID.randomUUID();
        String jwtSecretKey = uuid.toString().replace("-", "");
        return jwtSecretKey;
    }
}