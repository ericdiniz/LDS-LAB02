package com.ldslab02.alugarAutomovel.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ldslab02.alugarAutomovel.models.Agents;
import com.ldslab02.alugarAutomovel.models.Agents.CreateAgents;
import com.ldslab02.alugarAutomovel.models.Agents.UpdateAgents;
import com.ldslab02.alugarAutomovel.services.AgentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agents")
@Validated
public class AgentsController {

    @Autowired
    private AgentsService agentsService;

    @GetMapping("/{id}")
    public ResponseEntity<Agents> findbyidAgents(@PathVariable Long id) {
        Agents obj = this.agentsService.findbyIdAgents(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateAgents.class)
    public ResponseEntity<Void> createAgents(@Valid @RequestBody Agents obj) {
        this.agentsService.createAgents(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateAgents.class)
    public ResponseEntity<Void> updateUser(@Valid @RequestBody Agents obj,
            @PathVariable Long id) {
        obj.setId(id);
        this.agentsService.updateAgents(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.agentsService.deleteAgents(id);
        return ResponseEntity.noContent().build();
    }
}
