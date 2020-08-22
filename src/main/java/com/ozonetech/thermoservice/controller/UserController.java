package com.ozonetech.thermoservice.controller;

import com.ozonetech.thermoservice.entity.Users;
import com.ozonetech.thermoservice.exception.ResourceNotFoundException;
import com.ozonetech.thermoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository ;

    @GetMapping()
    public List<Users> getAllUsers(){
        return this.userRepository.findAll() ;
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") long userId){
        return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
    }

    @PostMapping
    public Users createUser(@RequestBody Users users){
        return this.userRepository.save(users);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@RequestBody Users users,@PathVariable ("id") long userId){
        Users existingUser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
         existingUser.setFirstname(users.getFirstname());
         existingUser.setLastname(users.getLastname());
         existingUser.setEmail(users.getEmail());
         return this.userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable ("id") long userId)
    {
        Users existingUser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id : " + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build() ;
    }
}
