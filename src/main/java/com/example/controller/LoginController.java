package com.example.controller;

import com.example.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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
     * Testview model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value={"/", "/test"}, method = RequestMethod.GET)
    public ModelAndView testview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_outer");
        return modelAndView;
    }

    /**
     * Testview 2 model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value={"/", "/test_inner"}, method = RequestMethod.GET)
    public ModelAndView testview2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_inner");
        return modelAndView;
    }
}