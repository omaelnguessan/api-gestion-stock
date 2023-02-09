package com.omael.gestiondestock.controller;

import com.omael.gestiondestock.controller.api.UserApi;
import com.omael.gestiondestock.dto.UserDto;
import com.omael.gestiondestock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return this.userService.save(userDto);
    }

    @Override
    public UserDto findById(Integer userId) {
        return this.userService.findById(userId);
    }

    @Override
    public List<UserDto> findAll() {
        return this.userService.findAll();
    }

    @Override
    public void delete(Integer userId) {
        this.userService.delete(userId);
    }
}
