package com.demo.blockchain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.blockchain.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
