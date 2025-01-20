package com.demo.blockchain.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.blockchain.models.Paciente;
import com.demo.blockchain.repositories.PacienteRepository;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
