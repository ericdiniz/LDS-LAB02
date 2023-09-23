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

import com.ldslab02.alugarAutomovel.models.Vehicles;
import com.ldslab02.alugarAutomovel.models.Vehicles.CreateVehicle;
import com.ldslab02.alugarAutomovel.models.Vehicles.UpdateVehicle;
import com.ldslab02.alugarAutomovel.services.VehiclesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
@Validated
public class VehiclesController {

    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehicles> findByIdVehicles(@PathVariable Long id) {
        Vehicles obj = this.vehiclesService.findbyIdVehicle(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateVehicle.class)
    public ResponseEntity<Void> createVehicles(@Valid @RequestBody Vehicles obj) {
        this.vehiclesService.createVehicles(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateVehicle.class)
    public ResponseEntity<Void> updateUser(@Valid @RequestBody Vehicles obj, @PathVariable Long id) {
        // this.userService.create(obj);
        // URI uri = ServletUriComponentsBuilder
        // .fromCurrentRequest()
        // .path("/{id}")
        // .buildAndExpand(obj.getId())
        // .toUri();
        // return ResponseEntity.created(uri).build();

        obj.setId(id);
        this.vehiclesService.updateVehicles(obj, obj.isBlocked());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.vehiclesService.deleteVehicles(id);
        return ResponseEntity.noContent().build();
    }

}
