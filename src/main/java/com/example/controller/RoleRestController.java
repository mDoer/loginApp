package com.example.controller;

import com.example.jsonview.Views;
import com.example.model.AjaxResponseBody;
import com.example.model.Role;
import com.example.model.RoleAjaxResponseBody;
import com.example.model.UserAjaxResponseBody;
import com.example.service.RoleService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/getroles", method = RequestMethod.GET)
    public AjaxResponseBody<Role> getRolesViaAjax() {
        AjaxResponseBody<Role> result = new RoleAjaxResponseBody();
        result.setResult(roleService.listAll());
        result.setMsg("");
        return result;
    }

}