package com.yasminedpc.springdemo.Service.impl;

import com.yasminedpc.springdemo.Entity.User;
import com.yasminedpc.springdemo.Service.UserService;

import com.yasminedpc.springdemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * add user
     */
    @Override
    public void addUser(User user) {

        userRepository.save(user);
    }

    /**
     * get users as list
     */
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * get user by id
     */

    @Override
    public User getUser(Integer id) {
//        check weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        return user;
    }

    /**
     * update user
     */

    @Override
    public void updateUser(Integer id, User user) {
//        check weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        user.setId(id);

        userRepository.save(user);

    }

    @Override
    public void deleteUser(Integer id) {
//        check weather the user is in database or not
        User user = userRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        userRepository.delete(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }



}