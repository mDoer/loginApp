package com.example.controller.userManagement;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserOverviewViewController {


    // Fixme set correct permission
    @PostAuthorize("hasPermission(returnObject,'USER_READ')")
    @RequestMapping(value="/users",method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView userOverview(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userOverview");
        return modelAndView;
    }


}
