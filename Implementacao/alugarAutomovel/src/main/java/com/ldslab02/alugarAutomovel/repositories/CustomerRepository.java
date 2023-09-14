package com.ldslab02.alugarAutomovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ldslab02.alugarAutomovel.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
