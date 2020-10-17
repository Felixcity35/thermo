package com.ozonetech.thermoservice.services;

import com.ozonetech.thermoservice.entity.Users;
import com.ozonetech.thermoservice.exception.ResourceNotFoundException;
import com.ozonetech.thermoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository ;


    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    public Users getUserById(long userId){
     return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
    }

    public Users createUser(Users users){
        return userRepository.save(users);
    }

    public Users updateUser(Users users, long userId){
        Users existingUser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
        existingUser.setFirstname(users.getFirstname());
        existingUser.setLastname(users.getLastname());
        existingUser.setEmail(users.getEmail());
        return userRepository.save(existingUser);
    }

    public ResponseEntity<Users> deleteUser(long userId){
        Users existingUser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
        userRepository.delete(existingUser);
        return ResponseEntity.ok().build() ;
    }
}
