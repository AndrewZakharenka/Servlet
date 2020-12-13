package com.jsp.repository;

import com.jsp.model.User;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUsers {
    public static InMemoryUsers inMemoryUsers = new InMemoryUsers();

    private static ArrayList<User> users = new ArrayList<>();

    private AtomicInteger idGenerator = new AtomicInteger(1);

    public User saveUser(User user){
        user.setId(idGenerator.getAndIncrement());

        users.add(user);

        return user;
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

}
