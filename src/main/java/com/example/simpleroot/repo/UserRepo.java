package com.example.simpleroot.repo;

import com.example.simpleroot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//since we are going to use the JPA repo we extend that here
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE ID = ?1", nativeQuery = true)
    User getUserByUserId(String userId);


    @Query(value = "SELECT * FROM USER WHERE ID = ?1 AND ADDRESS = ?2", nativeQuery = true)
    User getUserByUserIdAndAddress(String userId, String address);

}






//Notes:

/*
In the given code snippet, `UserRepo` is an interface that extends the `JpaRepository` interface. Let's break down the code and explain its meaning:

1. `public interface UserRepo`: This line declares a public interface named `UserRepo`. Interfaces in Java define a contract that classes can implement.

2. `extends JpaRepository<User, Integer>`: This line indicates that `UserRepo` extends the `JpaRepository` interface. The `JpaRepository` interface is part of the Spring Data JPA framework and provides a set of methods for performing common database operations on entities.

   - `User` is the entity class that `UserRepo` will operate on. It represents the type of entity managed by the repository.

   - `Integer` represents the type of the primary key of the `User` entity. In this case, it assumes the primary key is of type `Integer`.

The `JpaRepository` interface provides a variety of methods for performing CRUD (Create, Read, Update, Delete) operations and querying data from the database. By extending `JpaRepository`, the `UserRepo` interface inherits these methods and can be used to perform database operations on the `User` entity.

For example, some of the methods available in `UserRepo` include saving entities (`save()`), deleting entities (`delete()`), finding entities by ID (`findById()`), and executing custom queries using the `@Query` annotation.

By defining the `UserRepo` interface in this way, you can leverage the built-in functionality of `JpaRepository` to interact with the `User` entity in your Spring Data JPA-based application.
 */