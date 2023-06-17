package com.example.simpleroot.service;

import com.example.simpleroot.dto.UserDTO;
import com.example.simpleroot.entity.User;
import com.example.simpleroot.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//serivce eken thama repo ekata data yanne.
@Service //once u create a service class u need to add this annotation
@Transactional
public class UserService {
    //since we save data to the repo via the service we need to inject the repo here
    //For that we use the below annotation
    @Autowired
    private UserRepo userRepo;


    @Autowired
    private ModelMapper modelMapper;

    //data is taken through the DTO
    public UserDTO saveUser(UserDTO userDTO){
         userRepo.save(modelMapper.map(userDTO, User.class));
         //We save the data via the entity, but we get the data via the DTO.
        //So we have to Map these two, the entity and the DTO
        //To do this we need to add the modelmapper dependency
        //after add the dependency we need to inject the modelmapper to our project as a @Bean
        //that happens in the class where we have the main method (CHECK!!)
        //after that we can inject the class as done above using @Autowired

        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll(); //findAll() is a in-built method
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
        //here also we return a UserDTO object, so like in above saveUser() method we have to map.


        //Note
        /*
The given code snippet represents a method called getAllUsers() that returns a list of UserDTO objects. Let's break down the code and explain its functionality:

List<User> userList = userRepo.findAll();: This line retrieves all the User entities from the database using the findAll() method provided by the userRepo object. userRepo is assumed to be an instance of a repository interface that extends JpaRepository or a similar interface provided by Spring Data JPA. The findAll() method fetches all the records from the corresponding table in the database and returns them as a List of User objects.

modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType()): This line uses a modelMapper object to convert the retrieved User objects into a list of UserDTO objects. The modelMapper is an instance of a mapping library like MapStruct or ModelMapper, commonly used to perform object mapping or conversion between different object types.

modelMapper.map() method takes two arguments: the source object to be mapped (userList) and the target type (new TypeToken<List<UserDTO>>(){}.getType()).

new TypeToken<List<UserDTO>>(){}.getType() is used to define the target type for the mapping, which is a List<UserDTO>. This is required because of type erasure in Java generics, and using TypeToken allows the mapper to accurately map to the target type.

The modelMapper.map() method performs the mapping and returns a List<UserDTO> containing the mapped UserDTO objects.

The method then returns the resulting list of UserDTO objects.

In summary, the getAllUsers() method retrieves a list of User entities from the database, uses a mapping library (modelMapper) to convert them into a list of UserDTO objects, and returns the mapped UserDTO list. This allows you to separate the entity model (User) from the data transfer object (UserDTO) when returning data from the service layer to the caller, providing a clean separation of concerns and facilitating data transformation as needed.
        * */
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserID(String userID){
        User user = userRepo.getUserByUserId(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByUserIDAndAddress(String userId, String address){
        User user = userRepo.getUserByUserIdAndAddress(userId, address);
        return modelMapper.map(user, UserDTO.class);
    }

}





