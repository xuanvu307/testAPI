package com.example.testapi.dao;

import com.example.testapi.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"Nguyễn Văn A", "a@gmail.com","0123456789", "avatar"),
            new User(2,"Nguyễn Văn AA", "a@gmail.com","0123456789", "avatar"),
            new User(3,"Nguyễn Văn B", "a@gmail.com","0123456789", "avatar"),
            new User(4,"Nguyễn Văn C", "a@gmail.com","0123456789", "avatar"),
            new User(5,"Nguyễn Văn D", "a@gmail.com","0123456789", "avatar")
    ));
}
