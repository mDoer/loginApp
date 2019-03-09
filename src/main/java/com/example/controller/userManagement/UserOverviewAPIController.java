package com.example.controller.userManagement;

import com.example.model.dto.UserDTO;
import com.example.security.model.User;
import com.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type User overview api controller.
 */
@RestController
public class UserOverviewAPIController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Gets users.
     *
     * @return the users
     */
    @PostAuthorize("hasPermission(returnObject,'USER_READ')")
    @RequestMapping(value = "/users/api/getusers", method = RequestMethod.GET)
    public List<UserDTO> getUsers() {
        List<User> userList = this.userService.listAll();
        return userList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}
