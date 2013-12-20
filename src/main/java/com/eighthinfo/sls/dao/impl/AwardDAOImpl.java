package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.AwardDAO;
import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.model.PlayerWinPrize;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM2:11
 */
@Repository("AwardDAO")
public class AwardDAOImpl extends BaseDAO implements AwardDAO {

    private final static String TABLE_NAME = "t_award";
    private final static String PLAYER_WIN_PRIZE_TABLE_NAME = "t_player_win_prize";


    @Override
    public List<Award> loadAwardListByLevel(int level) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(TABLE_NAME);
        sql.append(" WHERE level = ? ");
        sql.append(" ORDER BY remain ");

        return getJdbcTemplate().queryForList(sql.toString(), Award.class, level);
    }

    public String getAwardRateOfWin(String awardId){
        StringBuilder sql = new StringBuilder("select rate_of_win from ")
                .append(TABLE_NAME).append(" where award_id=?");
        return getJdbcTemplate().queryForObject(sql.toString(),new Object[]{awardId},String.class);

    }

    @Override
    public Award getAward(String awardId) {
        StringBuilder sql = new StringBuilder("select * from ")
                .append(TABLE_NAME).append(" where award_id=?");
        List<Award> awardList = getJdbcTemplate().query(sql.toString(),new String[]{awardId},new RowMapper<Award>() {
            @Override
            public Award mapRow(ResultSet rs, int rowNum) throws SQLException {
                Award award = new Award();
                award.setAwardId(rs.getString("award_id"));
                award.setAwardName(rs.getString("award_name"));
                award.setBgHref(rs.getString("bg_href"));
                award.setDescription(rs.getString("description"));
                award.setDetailHref(rs.getString("detail_href"));
                //award.setLevel(rs.getInt("level"));
                award.setRateOfWin(rs.getString("rate_of_win"));
                award.setRemain(rs.getInt("remain"));
                award.setTotal(rs.getInt("total"));
                award.setPrice(rs.getLong("price"));
                return award;
            }
        });
        Award award = new Award();
        if(!awardList.isEmpty()&&awardList.size() > 0){
            award = awardList.get(0);
        }
        return award;
    }

    @Override
    public void savePlayerWinPrize(final PlayerWinPrize playerWinPrize) {
        StringBuilder sql = new StringBuilder("insert into ")
                .append(PLAYER_WIN_PRIZE_TABLE_NAME)
                .append(" (player_win_prize_id,player_id,award_id,price,opt_time) values(?,?,?,?,?)");
        getJdbcTemplate().update(sql.toString(), new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, playerWinPrize.getPlayerWinPrizeId());
                ps.setString(2, playerWinPrize.getPlayerId());
                ps.setString(3, playerWinPrize.getAwardId());
                ps.setLong(4,playerWinPrize.getPrice());
                ps.setString(5, playerWinPrize.getOptTime());
            }

        });
    }

    @Override
    public int getPlayerPrizeTotalPrice(String playerId) {
        StringBuilder sql = new StringBuilder("select sum(price) from ")
                .append(PLAYER_WIN_PRIZE_TABLE_NAME)
                .append(" where player_id = '").append(playerId).append("'")
                .append(" group by player_id");

        return getJdbcTemplate().queryForInt(sql.toString());
    }
}
