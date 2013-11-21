package com.eighthinfo.sls.service;

import com.eighthinfo.sls.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/login")
@Service("loginService")
public class LoginService {

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @RequestMapping("/{userId}")
    @ResponseBody
    public User login(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return user;
    }

}
