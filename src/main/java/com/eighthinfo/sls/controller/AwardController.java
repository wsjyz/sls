package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Award;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dam
 * Date: 13-11-22
 */
@Controller
@RequestMapping(value = "/award")
public class AwardController {


    @ResponseBody
    @RequestMapping(value = {"/getAwardList"})
    public List<Award> getAwardList(){
        List<Award> awardList = new ArrayList<Award>();
        return awardList;
    }
}
