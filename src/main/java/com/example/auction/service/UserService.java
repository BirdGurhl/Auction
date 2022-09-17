package com.example.auction.service;

import com.example.auction.pojo.User;

public interface UserService {
    User doLogin(String username, String password);
    //注册信息
    void registerUser(User user);
}
