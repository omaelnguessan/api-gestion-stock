package com.omael.gestiondestock.services;

import com.omael.gestiondestock.dto.UserDto;
import com.omael.gestiondestock.dto.UserDto;

import java.util.List;

public interface UserService {
    
    UserDto save(UserDto userDto);

    UserDto findById(Integer userId);

    List<UserDto> findAll();

    void delete(Integer userId);
}
