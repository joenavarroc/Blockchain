package com.demo.blockchain.blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una cadena de bloques (blockchain).
 * Contiene una lista de bloques conectados entre sí.
 */
public class BlockChain {

    private List<Block> chain;

    public BlockChain() {
        chain = new ArrayList<>();
        // Añadir el bloque génesis
        chain.add(createGenesisBlock());
    }

    /**
     * Crea el bloque génesis, el primer bloque de la blockchain.
     *
     * @return El bloque génesis.
     */
    private Block createGenesisBlock() {
        return new Block("Genesis Block", "0"); // Bloque inicial sin bloque anterior
    }

    /**
     * Añadir un bloque a la cadena.
     * 
     * @param data Los datos que contiene el nuevo bloque.
     */
    public void addBlock(String data) {
        Block newBlock = new Block(data, getLatestBlock().getHash());
        chain.add(newBlock);
    }

    /**
     * Verificar la validez de la cadena de bloques comprobando la integridad de los hashes.
     *
     * @return true si la blockchain es válida, false de lo contrario.
     */
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Verifica que el hash actual coincida con el calculado
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Verifica que el hash del bloque anterior coincida
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtener el último bloque en la cadena.
     *
     * @return El último bloque de la cadena.
     */
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    /**
     * Obtener la lista completa de bloques.
     *
     * @return La lista de bloques en la cadena.
     */
    public List<Block> getChain() {
        return chain;
    }

    /**
     * Imprimir toda la blockchain mostrando los datos, hashes y hashes previos de cada bloque.
     */
    public void printBlockchain() {
        for (int i = 0; i < chain.size(); i++) {
            Block block = chain.get(i);
            System.out.println("Block " + i + ":");
            System.out.println("Data: " + block.getData());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Timestamp: " + block.Timestamp);
            System.out.println("----------------------------");
        }
    }
    
}
