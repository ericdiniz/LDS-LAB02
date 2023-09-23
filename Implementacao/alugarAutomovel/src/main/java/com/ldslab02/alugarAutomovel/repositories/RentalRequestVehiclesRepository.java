package com.ldslab02.alugarAutomovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldslab02.alugarAutomovel.models.RentalRequestVehicles;

@Repository
public interface RentalRequestVehiclesRepository extends JpaRepository<RentalRequestVehicles, Long> {
    // Métodos personalizados, se necessário
}