package com.restapi.springbootapp.controller;

import com.restapi.springbootapp.entity.User;
import com.restapi.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create a new user

    @PostMapping("/students")
    public ResponseEntity<?> addUser(@RequestBody User user){
        Map<String,String> errors = new HashMap<>();
        if(user.getName()==null || user.getName().trim().isEmpty()){
            errors.put("name", "name is required");

        }
        if(user.getGrade()<1){
            errors.put("Grade","Grade should be above 1");
        }
        if(user.getGrade()>12){
            errors.put("Grade","Grade should be below 13");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        // if user is valid then save it
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
    }


    // get all user
    @GetMapping("/students")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    // get user by id

    @GetMapping("/students/{id}")

    public ResponseEntity<User> getUserByid(@PathVariable Long id){
        Optional<User> user = userService.getUserid(id);
        return user.map(ResponseEntity:: ok).orElseGet(()->ResponseEntity.notFound().build());

    }

    // update user by id

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {

        Map<String,String> errors = new HashMap<>();
        if(user.getName()==null || user.getName().trim().isEmpty()){
            errors.put("name", "name is required");

        }
        if(user.getGrade()<1){
            errors.put("Grade","Grade should be above 1");
        }
        if(user.getGrade()>12){
            errors.put("Grade","Grade should be below 13");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user by id
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUserByid(id);
        return ResponseEntity.ok("User is deleted");


    }

}






