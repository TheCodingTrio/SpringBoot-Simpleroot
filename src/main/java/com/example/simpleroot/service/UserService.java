package com.example.simpleroot.service;

import com.example.simpleroot.dto.UserDTO;
import com.example.simpleroot.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//serivce eken thama repo ekata data yanne.
@Service //once u create a service class u need to add this annotation
@Transactional
public class UserService {
    //since we save data to the repo via the service we need to inject the repo here
    //For that we use the below annotation
    @Autowired
    private UserRepo userRepo;

    //data is taken through the DTO
    public String saveUser(UserDTO userDTO){
         userRepo.save(userDTO);
         //We save the data via the entity, but we get the data via the DTO.
        //So we have to Map these two, the entity and the DTO
        //To do this we need to add the modelmapper dependency
        //after add the dependency we need to inject the modelmapper to our project as a @Bean
        //that happens in the class where we have the main method (CHECK!!)
    }
}
