package com.eighthinfo.sls.dao.user;

import com.eighthinfo.sls.model.User;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:48
 */
public interface UserDAO {
    void save(User user);

    User get(String userId);

    User getByName(String userName);

}
