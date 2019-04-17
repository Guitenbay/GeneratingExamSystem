package com.software.test.generatingexam.controller;

import com.software.test.generatingexam.bean.User;
import com.software.test.generatingexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public String getUserById(@PathVariable int id, ModelMap map) {

        User user = userService.selectUserById(id);

        map.addAttribute("user", user);

        return "index"; // index.html
    }

}
