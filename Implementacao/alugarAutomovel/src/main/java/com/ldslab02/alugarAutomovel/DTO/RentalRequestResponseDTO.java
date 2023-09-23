package com.ldslab02.alugarAutomovel.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.ldslab02.alugarAutomovel.models.RentalRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalRequestResponseDTO {
    private Long id;
    private String date;
    private CustomerDTO customer;
    private List<VehicleDTO> vehicles;

    public RentalRequestResponseDTO(RentalRequest rentalRequest) {
        this.id = rentalRequest.getId();
        this.date = rentalRequest.getDate();
        this.customer = new CustomerDTO(rentalRequest.getCustomer());
        this.vehicles = rentalRequest.getVehicles().stream()
                .map(vehicle -> new VehicleDTO(vehicle))
                .collect(Collectors.toList());
    }
}
