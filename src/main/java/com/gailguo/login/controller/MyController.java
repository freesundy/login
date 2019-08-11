package com.gailguo.login.controller;


import com.gailguo.login.bean.CustomUser;
import com.gailguo.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(path = "/")
public class MyController {


    @Resource
    UserService customUserService;

    @ResponseBody
    @RequestMapping(path = "/user/{id}")
    public CustomUser findById(@PathVariable("id") int id){
        return   customUserService.findById(id);

    }


    @RequestMapping(path = "/resource", method = RequestMethod.GET)
    public String login(Model modelAndView){
        //
        return "resource1";
    }

}
