package com.example.simpleroot.controller;

import com.example.simpleroot.dto.UserDTO;
import com.example.simpleroot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*@RestController: This annotation is a combination of @Controller and @ResponseBody.
It is used to mark a class as a RESTful controller that handles HTTP requests and returns the
response in a format suitable for RESTful APIs.
The @RestController annotation is typically used in combination with other mapping annotations,
such as @RequestMapping and HTTP method-specific annotations like @GetMapping, @PostMapping,
@PutMapping, or @DeleteMapping.*/


@RequestMapping(value = "api/v1/user")
/*@RequestMapping: This annotation is used to map HTTP requests to specific handler methods
within a controller class. It is used to define the base URL or URI pattern for the controller
and can also be used to specify additional request method conditions, headers, or parameters
to further narrow down the request mapping.*/

@CrossOrigin
/*@CrossOrigin: This annotation enables Cross-Origin Resource Sharing (CORS) for a controller or handler method.
It allows controlled access to resources from different domains or origins.
By specifying this annotation, you can configure the allowed origins, HTTP methods, headers,
and other CORS-related settings*/
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
    //From the frontend we send data in JSON object type format.
    //So the incoming JSON object type data can be converted to java object type using the @RequestBody annotation

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return  userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserId/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID ){
        return userService.getUserByUserID(userID);

    }

    @GetMapping("/getUserByUserIdAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIDAndAddress(@PathVariable String userID, @PathVariable String address ){
        System.out.println("User ID : " + userID + "Address : " + address);
        return userService.getUserByUserIDAndAddress(userID, address);
    }


} // end of UserController class
