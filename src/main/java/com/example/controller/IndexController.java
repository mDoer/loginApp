package com.example.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


  //  @PostAuthorize("hasPermission(returnObject,'INDEX_READ')")
    @RequestMapping(value="/index",method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView indexView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
