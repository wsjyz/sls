package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.dao.PlayerDAO;
import com.eighthinfo.sls.model.Player;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

/**
 * User: dam
 * Date: 13-11-23
 */
@Repository("PlayerDAO")
public class PlayerDAOImpl extends BaseDAO implements PlayerDAO{

    private final static String SQL_INSERT = "INSERT INTO t_user (user_id,user_name,male) values (?,?,?)";
    private final static String SQL_QUERY = "SELECT * FROM t_user WHERE user_id = ?";
    private final static String SQL_QUERY_BY_NAME = "SELECT * FROM t_user WHERE user_name = ?";
    private final static String SQL_UPDATE = "UPDATE t_user SET user_id=?,user_name=?,male=? WHERE user_id=?";

    @Override
    public Player get(String userId) {
        return getJdbcTemplate().queryForObject(SQL_QUERY, BeanPropertyRowMapper.newInstance(Player.class), userId);
    }

    @Override
    public void save(Player player) {
        int affectCount = getJdbcTemplate().update(SQL_UPDATE, player.getUserId(), player.getUserName(), player.getMale(), player.getUserId());
        if (affectCount == 0) {
            getJdbcTemplate().update(SQL_INSERT, player.getUserId(), player.getUserName(), player.getMale());
        }
    }

    @Override
    public Player getByName(String userName) {
        return getJdbcTemplate().queryForObject(SQL_QUERY_BY_NAME, BeanPropertyRowMapper.newInstance(Player.class), userName);
    }
}
