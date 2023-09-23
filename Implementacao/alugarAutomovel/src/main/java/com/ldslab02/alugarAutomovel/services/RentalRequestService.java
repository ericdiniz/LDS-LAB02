package com.ldslab02.alugarAutomovel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.Customer;
import com.ldslab02.alugarAutomovel.models.RentalRequest;
import com.ldslab02.alugarAutomovel.models.RentalRequestVehicles;
import com.ldslab02.alugarAutomovel.models.Vehicles;
import com.ldslab02.alugarAutomovel.repositories.CustomerRepository;
import com.ldslab02.alugarAutomovel.repositories.RentalRequestRepository;
import com.ldslab02.alugarAutomovel.repositories.RentalRequestVehiclesRepository;
import com.ldslab02.alugarAutomovel.repositories.VehiclesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RentalRequestService {

    @Autowired
    private RentalRequestRepository rentalRequestRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehiclesRepository vehicleRepository;

    @Autowired
    private RentalRequestVehiclesRepository rentalRequestVehiclesRepository;

    public List<RentalRequest> getAllRentalRequests() {
        return rentalRequestRepository.findAll();
    }

    public RentalRequest getRentalRequest(Long id) {
        return rentalRequestRepository.findById(id).orElse(null);
    }

    public RentalRequest createRentalRequestWithVehicles(RentalRequest rentalRequest, Long customerId) {
        // Busque o cliente pelo ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + customerId));

        // Associe o cliente à solicitação de aluguel
        rentalRequest.setCustomer(customer);

        // Crie a lista de associações entre a solicitação de aluguel e os veículos
        List<RentalRequestVehicles> rentalRequestVehiclesList = new ArrayList<>();
        for (Vehicles vehicleId : rentalRequest.getVehicles()) {
            Vehicles vehicle = vehicleRepository.findById(vehicleId.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID: " + vehicleId));

            RentalRequestVehicles rentalRequestVehicles = new RentalRequestVehicles();
            rentalRequestVehicles.setRentalRequest(rentalRequest);
            rentalRequestVehicles.setVehicle(vehicle);
            rentalRequestVehiclesList.add(rentalRequestVehicles);
        }

        // Salve as associações entre a solicitação de aluguel e os veículos
        rentalRequestVehiclesList = rentalRequestVehiclesRepository.saveAll(rentalRequestVehiclesList);

        // Crie uma lista de veículos a partir das associações
        List<Vehicles> vehiclesList = rentalRequestVehiclesList.stream()
                .map(RentalRequestVehicles::getVehicle)
                .collect(Collectors.toList());

        // Associe as entidades de veículos à solicitação de aluguel
        rentalRequest.setVehicles(vehiclesList);

        // Salve a solicitação de aluguel
        return rentalRequestRepository.save(rentalRequest);
    }

    public RentalRequest updateRentalRequest(Long id, RentalRequest newRentalRequest) {
        Optional<RentalRequest> optionalRental = rentalRequestRepository.findById(id);
        if (optionalRental.isPresent()) {
            RentalRequest rental = optionalRental.get();
            // Atualize os campos que você deseja alterar
            // Exemplo: rental.setDate(newRentalRequest.getDate());
            return rentalRequestRepository.save(rental);
        } else {
            newRentalRequest.setId(id);
            return rentalRequestRepository.save(newRentalRequest);
        }
    }

    public void deleteRentalRequest(Long id) {
        rentalRequestRepository.deleteById(id);
    }
}
