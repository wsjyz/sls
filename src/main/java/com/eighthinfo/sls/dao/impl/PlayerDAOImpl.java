package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.dao.PlayerDAO;
import com.eighthinfo.sls.model.Player;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: dam
 * Date: 13-11-23
 */
@Repository("PlayerDAO")
public class PlayerDAOImpl extends BaseDAO implements PlayerDAO {

    private final static String SQL_INSERT = "INSERT INTO t_player (player_id,player_name,male) values (?,?,?)";
    private final static String SQL_QUERY = "SELECT * FROM t_player WHERE player_id = ?";
    private final static String SQL_UPDATE_INFO = "UPDATE t_player SET player_name=?,male=? WHERE player_id=?";

    @Override
    public Player get(String userId) {
        List<Player> playerList = getJdbcTemplate().query(SQL_QUERY,new String[]{userId},new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                Player player = new Player();
                player.setPlayerId(rs.getString("player_id"));
                player.setExperience(rs.getLong("experience"));
                player.setMale(rs.getInt("male"));
                player.setNickName(rs.getString("player_name"));
                return player;
            }
        });
        Player player = null;
        if(!playerList.isEmpty() && playerList.size()>0){
            player = playerList.get(0);
        }
        return player;
    }

    @Override
    public void save(Player player) {
        int affectCount = getJdbcTemplate().update(SQL_UPDATE_INFO, player.getNickName(), player.getMale(), player.getPlayerId());
        if (affectCount == 0) {
            getJdbcTemplate().update(SQL_INSERT, player.getPlayerId(), player.getNickName(), player.getMale());
        }
    }

    public int updateExp(String playerId,long exp){
        StringBuilder sql = new StringBuilder("update t_player set experience = experience +"+exp)
                .append(" where player_id = ?");
        return getJdbcTemplate().update(sql.toString(),playerId);
    }

}
