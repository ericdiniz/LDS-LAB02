package com.ldslab02.alugarAutomovel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldslab02.alugarAutomovel.models.User;
import com.ldslab02.alugarAutomovel.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findbyId(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(
                () -> new RuntimeException("Usuário não encontrado" + id + "Tipo: " + User.class.getName()));
    }

    @Transactional
    public User createUser(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User updateUser(User obj) {
        User newObj = findbyId(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void deleteUser(Long id) {
        findbyId(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }

}
