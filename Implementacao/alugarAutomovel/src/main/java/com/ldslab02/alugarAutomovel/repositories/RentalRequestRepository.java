package com.ldslab02.alugarAutomovel.repositories;

import com.ldslab02.alugarAutomovel.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRequestRepository extends JpaRepository<RentalRequest, Long> {
}