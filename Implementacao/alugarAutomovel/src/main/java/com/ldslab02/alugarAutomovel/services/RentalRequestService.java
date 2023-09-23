package com.ldslab02.alugarAutomovel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.RentalRequest;
import com.ldslab02.alugarAutomovel.repositories.RentalRequestRepository;

@Service
public class RentalRequestService {

    @Autowired
    private RentalRequestRepository rentalRequestRepository;

    public List<RentalRequest> getAllRentalRequest() {
        return rentalRequestRepository.findAll();
        
    }

}
