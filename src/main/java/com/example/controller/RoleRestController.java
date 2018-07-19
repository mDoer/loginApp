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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The type Role rest controller.
 */
@RestController
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    /**
     * Gets roles via ajax.
     *
     * @return the roles via ajax
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/getroles", method = RequestMethod.GET)
    public AjaxResponseBody<Role> getRolesViaAjax() {
        AjaxResponseBody<Role> result = new RoleAjaxResponseBody();
        result.setResult(roleService.listAll());
        result.setMsg("");
        return result;
    }


    /**
     * Gets privileges via ajax.
     *
     * @return the privileges via ajax
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/privileges", method = RequestMethod.GET)
    public AjaxResponseBody<Privilege> getPrivilegesViaAjax() {
        AjaxResponseBody<Privilege> result = new PrivilegeAjaxResponseBody();
        result.setResult(privilegeService.findAll());
        System.out.println(privilegeService.findAll().size());
        result.setMsg("");
        return result;
    }


    /**
     * Gets role privilege mapping via ajax.
     *
     * @param id the id
     * @return the role privilege mapping via ajax
     */
//todo maybe do via sql?
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/roleprivilegemapping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody<RolePrivilege> getRolePrivilegeMappingViaAjax(@RequestParam("id") int id) {
        AjaxResponseBody<RolePrivilege> result = new RolePrivilegeResponseBody();
        Role role;
        List<Privilege> privilegeList;
        List<RolePrivilege> rolePrivilegeList;


        try {
            role = roleService.findRoleByID(id).get();   //fixme check if present
        } catch (Exception e) {
            result.setMsg("unknown role id");   //FIXME Log some shit
            return result;
        }

        privilegeList = privilegeService.findAll();
        rolePrivilegeList = RoleRestHelper.mapRolePrivileges(role, privilegeList);

        result.setResult(rolePrivilegeList);

        result.setMsg("");
        return result;
    }


    @JsonView(Views.Public.class)
    @RequestMapping(value = "/roles/api/roleprivilegemapping", method = RequestMethod.POST)
    public ModelAndView updateRolesPrivilegesMapping(@RequestBody List<RolePrivilege> rolePrivilegeList) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("successMessage", "Updated roles and permissions");
        modelAndView.setViewName("redirect:/roles");

        return modelAndView;
    }





}