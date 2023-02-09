package com.omael.gestiondestock.controller.api;

import com.omael.gestiondestock.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.omael.gestiondestock.utils.Constants.APP_ROOT;

public interface UserApi {

    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto save(UserDto userDto);

    @GetMapping(value = APP_ROOT + "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto findById(Integer userId);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/users/delete/{userId}")
    void delete(Integer userId);
}
