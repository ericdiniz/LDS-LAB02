package com.ldslab02.alugarAutomovel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rental_request_vehicles")
@Getter
@Setter
public class RentalRequestVehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_RentalRequest")
    private RentalRequest rentalRequest;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicles vehicle;
}
