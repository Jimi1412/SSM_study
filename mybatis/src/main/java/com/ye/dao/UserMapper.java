package com.ye.dao;

import com.ye.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //使用RowBounds实现分页
    List<User> getUserByRowBounds();
    //查询全部用户
    List<User> selectUser();
    //分页查询用户
    List<User> selectUserLimit(Map<String,Integer> map);
    //根据id查询用户
    User selectUserById(int id);

    //通过密码和名字查询用户
    User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);
    User selectUserByNP2(Map<String,Object> map);
    //添加一个用户
    int addUser(User user);
    //更新一个用户
    int updateUser(User user);
    //删除一个用户
    int deleteUser(int id);
    //模糊查询
    User selectLike(String str);
}
