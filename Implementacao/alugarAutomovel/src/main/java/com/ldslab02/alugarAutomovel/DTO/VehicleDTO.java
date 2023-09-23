package com.ldslab02.alugarAutomovel.DTO;

import com.ldslab02.alugarAutomovel.models.Vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    private Long id;
    private Long matricula;
    private String year;
    private String brand;
    private String model;
    private String numberPlate;
    private boolean blocked;

    public VehicleDTO(Vehicles vehicle) {
        this.id = vehicle.getId();
        this.matricula = vehicle.getMatricula();
        this.year = vehicle.getYear();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.numberPlate = vehicle.getNumberPlate();
        this.blocked = vehicle.isBlocked();
    }
}
