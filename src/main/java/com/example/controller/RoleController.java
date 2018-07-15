package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String userList(Model model) {
        return "roleOverview";
    }
}
