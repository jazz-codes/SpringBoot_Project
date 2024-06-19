package com.yasminedpc.springdemo.Service;

import com.yasminedpc.springdemo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);




    //public UserDetails loadUserByUsername(String username);
}