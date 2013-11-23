package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.dao.UserDAO;
import com.eighthinfo.sls.model.Player;
import com.eighthinfo.sls.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:49
 */
@Repository("UserDAO")
public class UserDAOImpl extends BaseDAO implements UserDAO {


    @Override
    public User findUserByLoginNameAndPsw(String loginName, String password) {

        String sql = "select * from t_user where login_name=? and password=?";
        List<User> userList =  getJdbcTemplate().query(sql, new Object[]{loginName, password}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getString("user_id"));
                return user;
            }
        });
        if(userList != null){
            return userList.get(0);
        }
        return null;
    }
}
