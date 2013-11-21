package com.eighthinfo.sls.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-21
 * Time: PM3:12
 */
public class BaseDAO {
    @Autowired
    protected JdbcTemplate jdbcTemplate;


}
