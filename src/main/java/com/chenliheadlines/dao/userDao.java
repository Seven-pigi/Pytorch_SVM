package com.chenliheadlines.dao;

import com.chenliheadlines.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDao extends JpaRepository<User,Integer> {
    public User getByPasswordAndUsername(String username,String password);
}
