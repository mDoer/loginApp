package com.example.controller;


import javax.annotation.PostConstruct;

import com.example.jsonview.Views;
import com.example.model.AjaxUserResponseBody;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserRestController {


    @Autowired
    private UserService userService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users/api/getusers", method = RequestMethod.GET)
    public AjaxUserResponseBody getSearchResultViaAjax() {

        AjaxUserResponseBody result = new AjaxUserResponseBody();

        result.setResult(userService.listAll());
        result.setMsg("");

        System.out.println(result.getResult().size());
        //AjaxResponseBody will be converted into json format and send back to the request.
        return result;

    }

}
