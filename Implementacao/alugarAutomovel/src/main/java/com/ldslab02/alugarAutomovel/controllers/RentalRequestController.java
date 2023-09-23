package com.ldslab02.alugarAutomovel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldslab02.alugarAutomovel.services.RentalRequestService;
import com.ldslab02.alugarAutomovel.models.RentalRequest;

@RestController
@RequestMapping("/orders")
public class RentalRequestController {

    @Autowired
    private RentalRequestService rentalRequestService;

    @GetMapping
    public List<RentalRequest> getAllRentalRequest() {
        return rentalRequestService.getAllRentalRequest();
    }
}
