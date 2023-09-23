package com.ldslab02.alugarAutomovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldslab02.alugarAutomovel.models.Vehicles;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {

}
