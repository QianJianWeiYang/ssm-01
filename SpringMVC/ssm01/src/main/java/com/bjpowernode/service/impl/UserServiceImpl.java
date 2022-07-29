package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className:UserServiceImpl
 * package:com.bjpowernode.service.impl
 * Description:
 * Date:2022-07-26 , 15:40
 * author:2451431209@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> selectUserPage(String userName, String userSex, Integer page, int pageSize) {
        PageHelper .startPage(page,pageSize);
        //按条件查询
        List<User> list=userMapper.selectUserPage(userName,userSex);
        PageInfo<User> pageInfo=new PageInfo<>(list);
        return pageInfo.getList();
    }


    @Override
    public int getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName,userSex);
    }

    @Override
    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
