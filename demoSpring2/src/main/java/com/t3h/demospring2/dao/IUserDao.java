package com.t3h.demospring2.dao;

import com.t3h.demospring2.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> getAllUser();
}
