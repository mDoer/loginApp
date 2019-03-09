package com.example.controller.userManagement;

import com.example.model.dto.UserDTO;
import com.example.security.model.User;
import com.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDetailsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    // Fixme set correct permission
    @PostAuthorize("hasPermission(returnObject,'USER_READ')")
    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    @ResponseBody
    public ModelAndView userOverview(@PathVariable Integer id,ModelAndView modelAndView) {
        User user = userService.loadUserByID(id);
        modelAndView.addObject("user", this.convertToDto(user));
        modelAndView.setViewName("/userDetail");
        return modelAndView;
    }

    //FIXME duplicated code
    private UserDTO convertToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }


}
