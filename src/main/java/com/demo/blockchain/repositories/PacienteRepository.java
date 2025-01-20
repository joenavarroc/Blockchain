package com.demo.blockchain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.blockchain.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

