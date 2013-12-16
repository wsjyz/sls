package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Hall;
import com.eighthinfo.sls.service.HallService;
import com.eighthinfo.sls.service.impl.HallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: dam
 * Date: 13-11-22
 */
@Controller
@RequestMapping(value = "/hall")
public class HallController {

    @Autowired
    protected HallService hallService;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Hall get() {
        Hall hall = hallService.getIdleHall();
        return hall;
    }
}
