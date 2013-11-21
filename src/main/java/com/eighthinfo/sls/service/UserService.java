package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-20
 * Time: PM9:08
 */
@Controller
@RequestMapping("/user")
@Service
public class UserService {

    @RequestMapping("/get/{userId}")
    @ResponseBody
    public User getUser(@PathVariable String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("ivan");
        return user;
    }
}
