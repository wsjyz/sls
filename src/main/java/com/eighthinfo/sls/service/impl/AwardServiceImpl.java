package com.eighthinfo.sls.service.impl;

import com.eighthinfo.sls.dao.AwardDAO;
import com.eighthinfo.sls.model.Award;
import com.eighthinfo.sls.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: dam
 * Date: 13-11-23
 */
@Service("AwardService")
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardDAO awardDAO;

    @Override
    public List<Award> loadAwardListByLevel(int level) {
        return awardDAO.loadAwardListByLevel(level);
    }
}
