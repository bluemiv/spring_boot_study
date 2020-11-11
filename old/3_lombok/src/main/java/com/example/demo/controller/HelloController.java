package com.example.demo.controller;

import com.example.demo.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public User index() {
        final User user = new User();
        user.setUsername("hong");
        return user;
    }
}
