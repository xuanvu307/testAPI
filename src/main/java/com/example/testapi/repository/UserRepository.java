package com.example.testapi.repository;

import com.example.testapi.dao.UserDB;
import com.example.testapi.exception.NotFoundException;
import com.example.testapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepository {
    public User getUser(Integer id){
        Optional<User> user = UserDB.users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (user.isPresent()){
            return user.get();
        } else {
            throw new NotFoundException("id không tồn tại");
        }
    }

    public boolean checkId(Integer id){
        Optional<User> user = UserDB.users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst() ;
        return user.isPresent();
    }
}

