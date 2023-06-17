package com.example.simpleroot.controller;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getUser")
    public String getUser(){
        return "Simple-Root";
    }

    @PostMapping("/saveUser")
    public String saveUser(){
        return "User Saved !";
    }

    @PutMapping("/updateUser")
    public String updateUser(){
        return "User Updated !";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User Deleted !";
    }


} // end of UserController class
