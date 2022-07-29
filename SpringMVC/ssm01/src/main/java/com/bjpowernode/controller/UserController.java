package com.bjpowernode.controller;

import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * className:UserController
 * package:com.bjpowernode.controller
 * Description:
 * Date:2022-07-26 , 16:46
 * author:2451431209@qq.com
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public  static final int PAGE_SIZE =5;

    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName, String userSex, Integer page) {
        if (page == null) {
            page=1;
        }
        return userService.selectUserPage(userName,userSex,page,PAGE_SIZE);
    }

    /**
     * 获取总行数    url /user/getRowCount?userName=z&userSex=男
     */
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex) {

        return userService.getRowCount(userName,userSex);
    }

    /**
     * 根据用户ID删除用户   url /user/deleteUserById?userId= 15968162087363060
     */
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    /**
     * 增加用户 url /user/createUser(参数见下面)
     */
    @RequestMapping("/createUser")
    public int createUser(User user) {
        String userId=System.currentTimeMillis()+"";
        int si= (int) (Math.random()*(9999-1000)+1000);
        userId=userId+si;
       user.setUserId(userId);
        return userService.createUser(user);
    }


}
