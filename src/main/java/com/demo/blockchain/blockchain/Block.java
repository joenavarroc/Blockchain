package com.demo.blockchain.blockchain;

import java.security.MessageDigest;

/**
 * Clase que representa un bloque individual en la blockchain.
 * Cada bloque contiene un hash, el hash del bloque anterior, datos y una marca de tiempo.
 */
public class Block {
    public static final String Timestamp = null;
    private String previousHash; // Hash del bloque anterior
    private String data;         // Datos contenidos en este bloque
    private String hash;         // Hash actual del bloque
    private long timestamp;      // Marca de tiempo de creación del bloque

    /**
     * Constructor de la clase Block.
     *
     * @param data Los datos que contiene este bloque.
     * @param previousHash El hash del bloque anterior.
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash(); // Calcula el hash del bloque al crearlo
    }

    /**
     * Calcula el hash del bloque basándose en sus propiedades.
     *
     * @return El hash calculado como una cadena hexadecimal.
     */
    public String calculateHash() {
        String input = previousHash + Long.toString(timestamp) + data;
        return applySHA256(input);
    }

    /**
     * Aplica el algoritmo SHA-256 para calcular un hash a partir de una entrada.
     *
     * @param input La cadena de entrada para calcular el hash.
     * @return El hash calculado como una cadena hexadecimal.
     */
    public static String applySHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getters
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setData'");
    }
}

