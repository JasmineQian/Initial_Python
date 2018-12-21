package com.jasmine.demo7.service;

import com.jasmine.demo7.entity.User;

import java.util.List;
public interface UserService {

    List<User> findAll();
    User findById(int userId);
    int create(String name,int age,String phone,String password);
    int update(int id,String name,int age,String phone,String password);
    int delete(int userId);
}

