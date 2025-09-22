package com.restapi.springbootapp.service;

import com.restapi.springbootapp.entity.User;
import com.restapi.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository =userRepository;
    }


    // add a new user
    public User addUser(User user){
        return userRepository.save(user);
    }

    // get all user
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    // get user by id
    public Optional<User> getUserid(Long id){
        return userRepository.findById(id);
    }

    // update the  user
    public User updateUser(Long id , User updateUser){
        Optional<User> existUser = userRepository.findById(id);
        if(existUser.isPresent()){
            User user = existUser.get();
            user.setName(updateUser.getName());
            user.setGrade(updateUser.getGrade());

            return userRepository.save(user);

        }
        else{
            throw new RuntimeException("User not found");
        }
    }


    public void deleteUserByid(Long id){
        userRepository.deleteById(id);

    }





}
