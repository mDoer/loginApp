package com.example.controller;

import com.example.jsonview.Views;
import com.example.model.*;
import com.example.model.ajax.AjaxResponseBody;
import com.example.model.ajax.PrivilegeAjaxResponseBody;
import com.example.model.ajax.RoleAjaxResponseBody;
import com.example.model.ajax.RolePrivilegeResponseBody;
import com.example.service.PrivilegeService;
import com.example.service.RoleService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/getroles", method = RequestMethod.GET)
    public AjaxResponseBody<Role> getRolesViaAjax() {
        AjaxResponseBody<Role> result = new RoleAjaxResponseBody();
        result.setResult(roleService.listAll());
        result.setMsg("");
        return result;
    }


    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/privileges", method = RequestMethod.GET)
    public AjaxResponseBody<Privilege> getPrivilegesViaAjax() {
        AjaxResponseBody<Privilege> result = new PrivilegeAjaxResponseBody();
        result.setResult(privilegeService.listAll());
        System.out.println(privilegeService.listAll().size());
        result.setMsg("");
        return result;
    }




    //todo maybe do via sql?
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/roleprivilegemapping", method = RequestMethod.GET)
    public AjaxResponseBody<RolePrivilege> getRolePrivilegeMappingViaAjax(@RequestParam("id") int id) {
        AjaxResponseBody<RolePrivilege> result = new RolePrivilegeResponseBody();
        Role role;
        List<Privilege> privilegeList;
        List<RolePrivilege> rolePrivilegeList;


        System.out.println(id);

        try{
            role = roleService.findRoleByID(id).get();   //fixme check if present
        }catch (Exception e){
            result.setMsg("unknown role id");   //FIXME Log some shit
            return result;
        }

        privilegeList = privilegeService.listAll();
        rolePrivilegeList = RoleRestHelper.mapRolePrivileges(role,privilegeList);

        result.setResult(rolePrivilegeList);

        result.setMsg("");
        return result;
    }




}