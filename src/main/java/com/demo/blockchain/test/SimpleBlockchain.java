package com.demo.blockchain.test;

import com.demo.blockchain.blockchain.BlockChain;

/**
 * Clase principal que inicializa y prueba la blockchain.
 */
public class SimpleBlockchain {
    public static void main(String[] args) {
        BlockChain blockchain = new BlockChain(); // Crea una nueva blockchain

        // Añade bloques a la blockchain
        blockchain.addBlock("First Block Data");
        blockchain.addBlock("Second Block Data");
        blockchain.addBlock("Third Block Data");

        // Imprime el contenido de la blockchain
        blockchain.printBlockchain();

        // Valida la blockchain
        System.out.println("Is blockchain valid? " + blockchain.isChainValid());
    }
}
