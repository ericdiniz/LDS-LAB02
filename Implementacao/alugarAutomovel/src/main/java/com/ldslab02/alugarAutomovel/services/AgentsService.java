package com.ldslab02.alugarAutomovel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.Agents;
import com.ldslab02.alugarAutomovel.repositories.AgentsRepository;

import jakarta.transaction.Transactional;

@Service
public class AgentsService {
    @Autowired
    private AgentsRepository agentsRepository;

    public Agents findbyIdAgents(Long id) {
        Optional<Agents> user = this.agentsRepository.findById(id);
        return user.orElseThrow(
                () -> new RuntimeException("Usuário não encontrado" + id + "Tipo: " + Agents.class.getName()));
    }

    @Transactional
    public Agents createAgents(Agents obj) {
        obj.setId(null);
        obj = this.agentsRepository.save(obj);
        return obj;
    }

    @Transactional
    public Agents updateAgents(Agents obj) {
        Agents newObj = findbyIdAgents(obj.getId());
        newObj.setPassword(obj.getPassword());
        newObj.setCnpj(obj.getCnpj());
        return this.agentsRepository.save(newObj);
    }

    public void deleteAgents(Long id) {
        findbyIdAgents(id);
        try {
            this.agentsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
