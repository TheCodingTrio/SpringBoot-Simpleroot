package com.example.simpleroot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String address;
}

//We named this package as dto. 
//We can name it as repository as well.
//Thats the developers personal preference.
