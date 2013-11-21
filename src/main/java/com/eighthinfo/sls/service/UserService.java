package com.eighthinfo.sls.service;

import com.eighthinfo.sls.dao.user.UserDAO;
import com.eighthinfo.sls.model.User;
import com.eighthinfo.sls.utils.ChineseNameGenerator;
import com.eighthinfo.sls.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-20
 * Time: PM9:08
 */
@Controller
@RequestMapping("/user")
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String userId) {
        return userDAO.get(userId);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.PUT, RequestMethod.POST})
    @ResponseBody
    public JsonResult save(@ModelAttribute User user) {
        try {
            userDAO.save(user);
            return new JsonResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(e.getMessage());
        }
    }

    @RequestMapping(value = "/randomName", method = RequestMethod.GET)
    @ResponseBody
    public String randomUserName() {
        return ChineseNameGenerator.getChinaName();
    }
}
