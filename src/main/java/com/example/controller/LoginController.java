package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.UserService;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * Login model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    /**
     * Home admin model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView homeAdmin(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = userService.loadUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + user.getUsername() + " (" + user.getUsername() + ")"); // fix user details to be more providing
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    /**
     * Home model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = userService.loadUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + user.getUsername() + " (" + user.getUsername() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("/home");
        return modelAndView;
    }


}