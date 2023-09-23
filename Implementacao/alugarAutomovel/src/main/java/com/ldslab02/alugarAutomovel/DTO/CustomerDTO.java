package com.ldslab02.alugarAutomovel.DTO;

import com.ldslab02.alugarAutomovel.models.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name; // Adicione outros campos necessários do cliente

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        // Configure outros campos aqui
    }
}
