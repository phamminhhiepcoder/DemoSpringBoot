package com.t3h.demospring2.service.impl;

import com.t3h.demospring2.dao.IUserDao;
import com.t3h.demospring2.dao.impl.UserDaoImpl;
import com.t3h.demospring2.entity.User;
import com.t3h.demospring2.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    private IUserDao iUserDao;
    public IUserServiceImpl(){
        iUserDao = new UserDaoImpl();
    }

    @Override
    public List<User> getAllUser() {
        return iUserDao.getAllUser();
    }
}
