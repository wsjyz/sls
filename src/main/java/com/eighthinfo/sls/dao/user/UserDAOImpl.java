package com.eighthinfo.sls.dao.user;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM1:49
 */
@Service
public class UserDAOImpl extends BaseDAO implements UserDAO {

    private final static String SQL_INSERT = "INSERT INTO t_user (user_id,user_name,male) values (?,?,?)";
    private final static String SQL_QUERY = "SELECT * FROM t_user WHERE user_id = ?";
    private final static String SQL_QUERY_BY_NAME = "SELECT * FROM t_user WHERE user_name = ?";
    private final static String SQL_UPDATE = "UPDATE t_user SET user_id=?,user_name=?,male=? WHERE user_id=?";

    @Override
    public User get(String userId) {
        return jdbcTemplate.queryForObject(SQL_QUERY, BeanPropertyRowMapper.newInstance(User.class), userId);
    }

    @Override
    public void save(User user) {
        int affectCount = jdbcTemplate.update(SQL_UPDATE, user.getUserId(), user.getUserName(), user.getMale(), user.getUserId());
        if (affectCount == 0) {
            jdbcTemplate.update(SQL_INSERT, user.getUserId(), user.getUserName(), user.getMale());
        }
    }

    @Override
    public User getByName(String userName) {
        return jdbcTemplate.queryForObject(SQL_QUERY_BY_NAME, BeanPropertyRowMapper.newInstance(User.class), userName);
    }
}
