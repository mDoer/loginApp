package com.example.controller.userManagement;

import com.example.model.forms.UserForm;
import com.example.security.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserFormController {


    @PostAuthorize("hasPermission(returnObject,'USER_READ')")
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public ModelAndView getUserForm(ModelAndView modelAndView) {
        modelAndView.addObject("userForm", new UserForm());
        modelAndView.setViewName("/userCreateForm");
        return modelAndView;
    }

    // Fixme set correct permission
    @PostAuthorize("hasPermission(returnObject,'USER_READ')")
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/userCreateForm");
            modelAndView.addObject("userForm", userForm);
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/userCreateForm");
        modelAndView.setStatus(HttpStatus.CREATED);
        return modelAndView;
    }


}
