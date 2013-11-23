package com.eighthinfo.sls.service;


import com.eighthinfo.sls.model.User;

/**
 * @author: Ivan Vigoss
 * Date: 13-11-20
 * Time: PM9:08
 */

public interface UserService {

    User findUserByLoginNameAndPsw(String loginName, String password);

//    public Player getUser(@PathVariable String userId) {
//        return userDAO.get(userId);
//    }
//
//    @RequestMapping(value = "/save", method = {RequestMethod.PUT, RequestMethod.POST})
//    @ResponseBody
//    public JsonResult save(@ModelAttribute Player player) {
//        try {
//            userDAO.save(player);
//            return new JsonResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new JsonResult(e.getMessage());
//        }
//    }
//
//    @RequestMapping(value = "/randomName", method = RequestMethod.GET)
//    @ResponseBody
//    public String randomUserName() {
//        return ChineseNameGenerator.getChinaName();
//    }
}
