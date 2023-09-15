package com.ldslab02.alugarAutomovel.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ldslab02.alugarAutomovel.models.Customer;
import com.ldslab02.alugarAutomovel.models.Customer.CreateCustomer;
import com.ldslab02.alugarAutomovel.models.User.UpdateUser;
import com.ldslab02.alugarAutomovel.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findByIdCustomer(@PathVariable Long id) {
        Customer obj = this.customerService.findbyIdCustomer(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateCustomer.class)
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer obj) {
        this.customerService.createCustomer(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateUser.class)
    public ResponseEntity<Void> updateUser(@Valid @RequestBody Customer obj, @PathVariable Long id) {
        obj.setId(id);
        this.customerService.updateCustomer(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
