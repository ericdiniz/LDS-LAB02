package com.ldslab02.alugarAutomovel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ldslab02.alugarAutomovel.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
