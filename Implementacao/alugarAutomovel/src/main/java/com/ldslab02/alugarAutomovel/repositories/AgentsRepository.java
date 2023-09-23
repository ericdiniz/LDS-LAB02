package com.ldslab02.alugarAutomovel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldslab02.alugarAutomovel.models.Agents;


public interface AgentsRepository extends JpaRepository<Agents, Long> {
    Optional<Agents> findByCnpj(String cnpj);
}
