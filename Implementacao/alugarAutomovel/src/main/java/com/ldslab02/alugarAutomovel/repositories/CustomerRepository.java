package com.ldslab02.alugarAutomovel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldslab02.alugarAutomovel.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCpf(String cpf);

}
