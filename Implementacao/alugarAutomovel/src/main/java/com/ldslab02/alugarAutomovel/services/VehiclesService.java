package com.ldslab02.alugarAutomovel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.Vehicles;
import com.ldslab02.alugarAutomovel.repositories.VehiclesRepository;

import jakarta.transaction.Transactional;

@Service
public class VehiclesService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    public Vehicles findbyIdVehicle(Long id) {
        Optional<Vehicles> vehicle = this.vehiclesRepository.findById(id);
        return vehicle.orElseThrow(
                () -> new RuntimeException("Veículo não encontrado" + id + "Tipo: " + Vehicles.class.getName()));
    }

    public List<Vehicles> getVehiclesByIds(List<Long> vehicleIds) {
        return vehiclesRepository.findAllById(vehicleIds);
    }

    @Transactional
    public Vehicles createVehicles(Vehicles obj) {
        obj.setId(null);
        obj = this.vehiclesRepository.save(obj);
        return obj;
    }

    @Transactional
    public Vehicles updateVehicles(Vehicles obj, boolean blocked) {
        Vehicles newObj = findbyIdVehicle(obj.getId());
        newObj.setMatricula(obj.getMatricula());
        newObj.setYear(obj.getYear());
        newObj.setBrand(obj.getBrand());
        newObj.setModel(obj.getModel());
        newObj.setNumberPlate(obj.getNumberPlate());
        newObj.setBlocked(blocked);
        return this.vehiclesRepository.save(newObj);
    }

    public void deleteVehicles(Long id) {
        findbyIdVehicle(id);
        try {
            this.vehiclesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
