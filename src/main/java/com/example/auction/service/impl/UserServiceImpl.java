package com.example.auction.service.impl;

import com.example.auction.mapper.UserMapper;
import com.example.auction.pojo.User;
import com.example.auction.pojo.UserExample;
import com.example.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User doLogin(String username, String password) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        //主要通过EqualTo方法拼接条件、密码来对比的，值什么等于什么
        criteria.andUsernameEqualTo(username);
        criteria.andUserpasswordEqualTo(password);
        List<User> users=userMapper.selectByExample(userExample);
        User user=null;
        //加上判断数据
        if(users!=null&&users.size()>0){ //判断数据库是否有数据进行返回到来
            user= users.get(0);//得到第一个元素
        }
        return user;
    }

    @Override
    public void registerUser(User user) {
        userMapper.insert(user);
    }
}
