package com.projeto.blockchainapi.util;

import com.projeto.blockchainapi.exception.ErroSHA256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String aplicarSha256(String input){

        try{
            MessageDigest digest = getSha256Instance();

            byte[] hash = digest.digest(input.getBytes());

            return calcularHash(hash);

        }catch (NoSuchAlgorithmException ex){
            throw new ErroSHA256(ex.getMessage());
        }
    }

    private static MessageDigest getSha256Instance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }

    private static String calcularHash(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }
        return hexString.toString();
    }
}
