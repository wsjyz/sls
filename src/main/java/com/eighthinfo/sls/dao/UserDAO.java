package com.eighthinfo.sls.dao;

import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.model.User;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:48
 */
public interface UserDAO {

     User findUserByLoginNameAndPsw(String loginName, String password);

}
