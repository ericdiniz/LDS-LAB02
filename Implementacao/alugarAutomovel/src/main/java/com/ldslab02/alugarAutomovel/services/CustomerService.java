package com.ldslab02.alugarAutomovel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.Customer;
import com.ldslab02.alugarAutomovel.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findbyIdCustomer(Long id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        return customer.orElseThrow(
                () -> new RuntimeException("Usuário não encontrado " + id + "Tipo: " + Customer.class.getName()));
    }

    public Customer findbyCPFCustomer(String CPF) {
        Optional<Customer> customer = this.customerRepository.findByCpf(CPF);
        return customer.orElseThrow(
                () -> new RuntimeException("Usuário não encontrado " + CPF + "Tipo: " + Customer.class.getName()));
    }

    @Transactional
    public Customer createCustomer(Customer obj) {
        obj.setId(null);
        obj = this.customerRepository.save(obj);
        return obj;
    }

    @Transactional
    public Customer updateCustomer(Customer obj) {
        Customer newObj = findbyIdCustomer(obj.getId());
        newObj.setPassword(obj.getPassword());
        newObj.setAddress(obj.getAddress());
        newObj.setIncome(obj.getIncome());
        newObj.setCpf(obj.getCpf());
        newObj.setName(obj.getName());
        newObj.setProfession(obj.getProfession());
        newObj.setRg(obj.getRg());
        return this.customerRepository.save(newObj);
    }

    public void deleteCustomer(Long id) {
        findbyIdCustomer(id);
        try {
            this.customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
