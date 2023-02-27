package com.example.testapi.repository;

import com.example.testapi.dao.UserDB;
import com.example.testapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepository {
    public User getUser(Integer id){
        Optional<User> user = UserDB.users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                ;
        if (user.isPresent()){
            return user.get();
        } else {
            // user lỗi id trả về 1 user mặc định có id = 0 và các giá trị null;
            User u = new User();
            u.setId(0);
//            throw new NotFoundException("id không tồn tại");
            return u;
        }
    }
}
