package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.Hall;
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

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Hall get() {
        Hall hall = new Hall();
        hall.setHost("127.0.0.1");
        hall.setPort(9110);
        hall.setPlayerCounts(2000);
        return hall;
    }
}
