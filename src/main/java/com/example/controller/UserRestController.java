package com.example.controller;


import com.example.jsonview.Views;
import com.example.model.UserAjaxResponseBody;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserRestController {


    @Autowired
    private UserService userService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users/api/getusers", method = RequestMethod.GET)
    public UserAjaxResponseBody getUsersViaAjax() {
        UserAjaxResponseBody result = new UserAjaxResponseBody();
        result.setResult(userService.listAll());
        result.setMsg("");
        return result;
    }

}
