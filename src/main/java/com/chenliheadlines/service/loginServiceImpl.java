package com.chenliheadlines.service;

import com.chenliheadlines.bean.User;
import com.chenliheadlines.dao.userDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@Service
@Component
public class loginServiceImpl implements UserService{
    private final userDao userDao;

    public loginServiceImpl(userDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String username, String password) {
        return userDao.getByPasswordAndUsername(username,password);
    }

    @Override
    public void insertUser(User user) {

        userDao.save(user);
    }
}
