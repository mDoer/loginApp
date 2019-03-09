package com.example.controller;


import com.example.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type User rest controller.
 */
@RestController
public class UserRestController {


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

/*    *//**
     * Gets users via ajax.
     *
     * @return the users via ajax
     *//*
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users/api/getusers", method = RequestMethod.GET)
    public UserAjaxResponseBody getUsersViaAjax() {
        UserAjaxResponseBody result = new UserAjaxResponseBody();
        result.setResult(customUserDetailsService.listAll());
        result.setMsg("");
        return result;
    }*/

}
