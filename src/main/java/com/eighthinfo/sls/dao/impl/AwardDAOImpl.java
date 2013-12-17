package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.AwardDAO;
import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.model.Award;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
}
