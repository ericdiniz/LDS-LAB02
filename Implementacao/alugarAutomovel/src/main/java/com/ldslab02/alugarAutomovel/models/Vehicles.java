package com.ldslab02.alugarAutomovel.models;

import com.ldslab02.alugarAutomovel.models.Customer.CreateCustomer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Vehicles.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Vehicles {

    public static final String TABLE_NAME = "Vehicle";

    public interface CreateVehicle {

    }

    public interface UpdateVehicle {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle", unique = true)
    private Long id;

    @Column(name = "matricula")
    @NotNull(groups = CreateVehicle.class)
    private Long matricula;

    @Column(name = "year")
    @NotNull(groups = CreateVehicle.class)
    @NotEmpty(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 4, max = 4)
    private String year;

    @Column(name = "brand", length = 100, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotEmpty(groups = CreateVehicle.class)
    @Size(groups = CreateCustomer.class, min = 2, max = 100)
    private String brand;

    @Column(name = "model", length = 100, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotEmpty(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 2, max = 100)
    private String model;

    @Column(name = "numberPlate", length = 100, nullable = false)
    @NotNull(groups = CreateVehicle.class)
    @NotEmpty(groups = CreateVehicle.class)
    @Size(groups = CreateVehicle.class, min = 2, max = 100)
    private String numberPlate;

    @Column(name = "blocked")
    private boolean blocked;
}
