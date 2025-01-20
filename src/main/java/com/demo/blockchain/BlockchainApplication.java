package com.demo.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

    public void addBlock(String blockData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBlock'");
    }

    public boolean isChainValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isChainValid'");
    }

    public Object getChain() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChain'");
    }

}
