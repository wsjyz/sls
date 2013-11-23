package com.eighthinfo.sls.controller;

import com.eighthinfo.sls.model.User;
import com.eighthinfo.sls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: dam
 * Date: 13-11-22
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping(value = "/")
    public String welcome(){
        return  "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLogin(User userModel){

        User user = userService.findUserByLoginNameAndPsw(userModel.getLoginName(),userModel.getPassword());

        String forward = null;
        if(user == null){
            forward = "redirect:/";
        }else{
            forward = "forward:/index";
        }
        return  forward;
    }
}
