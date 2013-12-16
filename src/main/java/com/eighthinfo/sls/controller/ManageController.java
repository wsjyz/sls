package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dam on 13-12-12.
 */
@Controller
@RequestMapping(value = "/manage")
public class ManageController {

    @Autowired
    protected HallService hallService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String redis() {
        return "/manage/redis";
    }

    @ResponseBody
    @RequestMapping(value = "/get-hall-list", method = RequestMethod.GET)
    public List<Hall> get() {
        List<Hall> hallList = hallService.getHallList();
        return hallList;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete() {
        return "/manage/delete";
    }
    @RequestMapping(value = "/online", method = RequestMethod.GET)
    public String onlineCounts() {
        return "/manage/playercounts";
    }
}
