package com.ldslab02.alugarAutomovel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldslab02.alugarAutomovel.services.RentalRequestService;
import com.ldslab02.alugarAutomovel.models.RentalRequest;

@RestController
@RequestMapping("/orders")
public class RentalRequestController {

    // The controller depends on the service class
    @Autowired
    private RentalRequestService rentalRequestService;

    // All orders
    @GetMapping
    public List<RentalRequest> getAllRentalRequest() {
        return rentalRequestService.getAllRentalRequests();
    }

    // Specific order
    @GetMapping("/{id}")
    public RentalRequest getRentalRequest(@PathVariable Long id) {
        return rentalRequestService.getRentalRequest(id);
    }

    // POST HTTP
    @PostMapping
    public RentalRequest createRentalRequest(@RequestBody RentalRequest rentalRequest) {
        return rentalRequestService.createRentalRequest(rentalRequest);
    }

}
