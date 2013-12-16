package com.eighthinfo.sls.dao.impl;

import com.eighthinfo.sls.dao.BaseDAO;
import com.eighthinfo.sls.dao.PlayerLevelSettingDAO;
import com.eighthinfo.sls.model.PlayerLevelSetting;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dam on 13-12-16.
 */
@Repository("UserLevelSettingDAO")
public class PlayerLevelSettingDAOImpl extends BaseDAO implements PlayerLevelSettingDAO {

    private final static String TABLE_NAME = "t_player_level_setting";

    @Override
    public List<PlayerLevelSetting> getUserLevelSetting() {
        StringBuilder sql = new StringBuilder("select * from ")
                .append(TABLE_NAME).append(" order by need_exp desc");
        return getJdbcTemplate().query(sql.toString(), new RowMapper<PlayerLevelSetting>() {
            @Override
            public PlayerLevelSetting mapRow(ResultSet resultSet, int i) throws SQLException {
                PlayerLevelSetting setting = new PlayerLevelSetting();
                setting.setLevelId(resultSet.getString("level_id"));
                setting.setLevelTitle(resultSet.getString("level_title"));
                setting.setNeedExp(resultSet.getLong("need_exp"));
                return setting;
            }
        });
    }
}
