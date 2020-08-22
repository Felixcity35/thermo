package com.ozonetech.thermoservice.repository;
import com.ozonetech.thermoservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Users,Long> {

}
