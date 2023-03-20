package com.chenliheadlines.service;


import com.chenliheadlines.bean.User;

public interface UserService{
    public User getUser(String username,String password);
    public void insertUser(User user);
}
