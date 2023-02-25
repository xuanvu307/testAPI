package com.example.testapi.repository;

import com.example.testapi.dao.UserDB;
import com.example.testapi.exception.BadRequest;
import com.example.testapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    public User getUser(Integer id){
        return UserDB.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->{
                    throw new BadRequest("Id user không tồn tại");
                });
    }

    public List<User> getAllUser(){
        return UserDB.users;
    }
}
