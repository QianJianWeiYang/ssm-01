package com.bjpowernode.mapper;

import com.bjpowernode.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * className:UserMapper
 * package:com.bjpowernode.mapper
 * Description:
 * Date:2022-07-26 , 15:12
 * author:2451431209@qq.com
 */

public interface UserMapper {
    //根据条件获取分页数据
    List<User> selectUserPage(
            @Param("userName") String userName,
            @Param("userSex") String userSex
    );


    //查询总行数
    int getRowCount(  @Param("userName") String userName,
                      @Param("userSex") String userSex);


    //根据id删除用户
    int deleteUserById(String userId);

    //增加用户
    int createUser(User user);
}
