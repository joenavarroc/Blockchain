package com.demo.blockchain.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.demo.blockchain.blockchain.Block;
import com.demo.blockchain.blockchain.BlockChain;

public class BlockchainTest {

    private BlockChain blockchain;

    @BeforeEach
    public void setUp() {
        blockchain = new BlockChain();
    }

    @Test
    public void testAddBlock() {
        blockchain.addBlock("First Block Data");
        blockchain.addBlock("Second Block Data");

        assertEquals(2, blockchain.getChain().size() - 1); // Excluyendo el bloque génesis
        assertEquals("First Block Data", blockchain.getChain().get(1).getData());
    }

    @Test
    public void testIsChainValid() {
        blockchain.addBlock("First Block Data");
        blockchain.addBlock("Second Block Data");

        assertTrue(blockchain.isChainValid());

        // Alterar los datos de un bloque para simular corrupción
        blockchain.getChain().get(1).setData("Tampered Data");
        assertFalse(blockchain.isChainValid());
    }

    @Test
    public void testGenesisBlock() {
        Block genesisBlock = blockchain.getChain().get(0);

        assertNotNull(genesisBlock);
        assertEquals("Genesis Block", genesisBlock.getData());
    }
}
