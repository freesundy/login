package com.gailguo.login.service;


import com.gailguo.login.bean.CustomUser;
import com.gailguo.login.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {



    @Resource
    private UserMapper userMapper;


    public CustomUser findById(Integer id){

        return userMapper.findById(id);

    }

}
