package com.ldslab02.alugarAutomovel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.RentalRequest;
import com.ldslab02.alugarAutomovel.repositories.RentalRequestRepository;

@Service
public class RentalRequestService {

    // The service uses the repository that uses Dependency Injection.

    @Autowired
    private RentalRequestRepository rentalRequestRepository;

    public List<RentalRequest> getAllRentalRequests() {
        return rentalRequestRepository.findAll();

    }

    public RentalRequest getRentalRequest(Long id) {
        return rentalRequestRepository.findById(id).orElse(null);
    }

    public RentalRequest createRentalRequest(RentalRequest rentalRequest) {
        return rentalRequestRepository.save(rentalRequest);
    }

}
