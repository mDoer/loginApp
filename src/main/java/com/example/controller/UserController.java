package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * The type User controller.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * User list string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("users", userService.listAll());
        return "userOverview";
    }


    /**
     * User details model and view.
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView userDetails(@PathVariable Integer id, ModelAndView model) {
        Optional<User> user = userService.findUserByID(id); //Fixme rename to optionakl
        if (user.isPresent()) {
            model.addObject("user", user.get());
            model.setViewName("userdetail");
            return model;
        } else {
            throw new IllegalStateException(); //FIXME nasty quick fix

        }
    }


    /**
     * Registration model and view.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * Create new user model and view.
     *
     * @param user          the user
     * @param bindingResult the binding result
     * @return the model and view
     */
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            try {
                userService.saveUser(user);
            } catch (Exception e) {
                modelAndView.setViewName("redirect:/error");    //FIXME Log some shit
                return modelAndView;
            }
            modelAndView.addObject("successMessage", "User has been created successfully");
            //modelAndView.addObject("user", new User());
            modelAndView.setViewName("redirect:/users");
        }
        return modelAndView;
    }


}
