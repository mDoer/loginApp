package com.example.controller;

import com.example.jsonview.Views;
import com.example.model.RolePrivilege;
import com.example.model.User;
import com.example.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Role controller.
 */
@Controller
public class RoleController {
    @Autowired
    private UserService userService;

    /**
     * User list string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String userList(Model model) {
        return "roleOverview";
    }



}
