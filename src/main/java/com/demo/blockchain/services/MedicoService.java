package com.demo.blockchain.services;

import com.demo.blockchain.blockchain.*;
import com.demo.blockchain.models.Medico;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {
    private List<Medico> medicos = new ArrayList<>();
    private BlockChain blockchain = new BlockChain();  // Usar la clase Blockchain

    // Obtener todos los médicos
    public List<Medico> getAllMedicos() {
        return medicos;
    }

    // Guardar un nuevo médico y agregarlo a la blockchain
    public void saveMedico(Medico medico) {
        // Asignar un ID único (siendo int)
        medico.setId(medicos.size() + 1);  // El ID será un número entero
        medicos.add(medico);

        // Convertir el médico en un bloque y añadirlo a la blockchain
        String blockData = "ID: " + medico.getId() + ", Nombre: " + medico.getNombre() +
                ", Especialidad: " + medico.getEspecialidad() +
                ", Certificado: " + medico.getCertificado();
        blockchain.addBlock(blockData);

        System.out.println("Bloque añadido a la blockchain: " + blockData);
    }

    // Validar si la blockchain es válida
    public boolean validarBlockchain() {
        return blockchain.isChainValid();
    }

    // Obtener la cadena de bloques
    public BlockChain getBlockchain() {
        return blockchain;
    }
}
