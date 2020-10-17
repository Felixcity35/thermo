package com.ozonetech.thermoservice.controller;

import com.ozonetech.thermoservice.entity.Users;
import com.ozonetech.thermoservice.exception.ResourceNotFoundException;
import com.ozonetech.thermoservice.repository.UserRepository;
import com.ozonetech.thermoservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserServices userServices ;

    @GetMapping()
    public List<Users> getAllUsers(){

        return userServices.getAllUser() ;
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") long userId){
        return userServices.getUserById(userId);
    }

    @PostMapping
    public Users createUser(@RequestBody Users users){
        return userServices.createUser(users);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@RequestBody Users users,@PathVariable ("id") long userId){
       return userServices.updateUser(users,userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable ("id") long userId)
    {
      return userServices.deleteUser(userId);
    }

}
