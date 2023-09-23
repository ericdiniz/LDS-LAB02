package com.ldslab02.alugarAutomovel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldslab02.alugarAutomovel.DTO.RentalRequestResponseDTO;
import com.ldslab02.alugarAutomovel.models.RentalRequest;
import com.ldslab02.alugarAutomovel.services.RentalRequestService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/orders")
public class RentalRequestController {

    @Autowired
    private RentalRequestService rentalRequestService;

    @GetMapping
    public List<RentalRequest> getAllRentalRequest() {
        return rentalRequestService.getAllRentalRequests();
    }

    @GetMapping("/{id}")
    public RentalRequestResponseDTO getRentalRequest(@PathVariable Long id) {
        RentalRequest rentalRequest = rentalRequestService.getRentalRequest(id);
        if (rentalRequest != null) {
            return new RentalRequestResponseDTO(rentalRequest);
        } else {
            throw new EntityNotFoundException("Solicitação de aluguel não encontrada com o ID: " + id);
        }
    }

    @PostMapping("/createWithVehicles/{id}")
    public RentalRequest createRentalRequestWithVehicles(@RequestBody RentalRequest rentalRequest,
            @PathVariable Long id) {
        return rentalRequestService.createRentalRequestWithVehicles(rentalRequest, id);
    }

    @PutMapping("/{id}")
    public RentalRequest updateRentalRequest(@PathVariable Long id, @RequestBody RentalRequest rentalRequest) {
        return rentalRequestService.updateRentalRequest(id, rentalRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalRequest(@PathVariable Long id) {
        rentalRequestService.deleteRentalRequest(id);
    }
}
