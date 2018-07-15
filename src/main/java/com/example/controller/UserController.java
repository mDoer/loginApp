package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("users", userService.listAll());
        return "userOverview";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userDetails(@PathVariable Integer id, Model model) {
        Optional<User> user = userService.findUserByID(id); //Fixme rename to optionakl
        if(user.isPresent()) {

            model.addAttribute("user", user.get());
            return "userdetail";
        }
        else{
            throw new IllegalStateException(); //FIXME nasty quick fix
        }
    }







}
