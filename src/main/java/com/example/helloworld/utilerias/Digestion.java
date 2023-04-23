package com.example.helloworld.utilerias;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digestion {
    public static String generateMd5(String input) {
        String palabraSecreta="Gera1989";
        byte[] arreglo;
        try {
            arreglo = generateSaltedMd5(input, palabraSecreta);
        } catch (NoSuchAlgorithmException e) {
            return "ERROR";
        }
        return toHexString(arreglo);
    }
    private static byte[] generateSaltedMd5(String source, String salt) throws NoSuchAlgorithmException {
        String input = source +salt;
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }    
    private static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        String hexa = number.toString(16);
        StringBuilder hexString = new StringBuilder(hexa);
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    public int errorParaDeteccionDeSonar(int a, int b) {
        return a+b;
    }

}
