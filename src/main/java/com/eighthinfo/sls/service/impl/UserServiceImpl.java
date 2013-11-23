package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.UserDAO;
import com.eighthinfo.sls.model.User;
import com.eighthinfo.sls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("UserDAO")
    private UserDAO userDAO;

    @Override
    public User findUserByLoginNameAndPsw(String loginName, String password) {
        return userDAO.findUserByLoginNameAndPsw(loginName,password);
    }
}
