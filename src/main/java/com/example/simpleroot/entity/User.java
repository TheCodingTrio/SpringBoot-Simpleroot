package com.example.simpleroot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data //to generate the getters and setters
public class User {
    @Id //primary key
    private int id;
    private String name;
    private String address;

}
