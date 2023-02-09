package com.omael.gestiondestock.services.impl;

import com.omael.gestiondestock.dto.UserDto;
import com.omael.gestiondestock.exception.EntityNotFoundException;
import com.omael.gestiondestock.exception.ErrorCodes;
import com.omael.gestiondestock.exception.InvalidEntityException;
import com.omael.gestiondestock.model.User;
import com.omael.gestiondestock.repository.UserRepository;
import com.omael.gestiondestock.services.UserService;
import com.omael.gestiondestock.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);
        
        if (!errors.isEmpty()) {
            log.error("Invalid user {}", userDto);
            throw new InvalidEntityException("Invalid provider", ErrorCodes.USER_NOT_VALID, errors);
        }
        
        return UserDto.fromEntity(
                this.userRepository.save(
                        UserDto.toEntity(userDto)
                )
        );
    }

    @Override
    public UserDto findById(Integer userId) {
        if (userId == null) {
            log.error("User ID not is empty");
            return null;
        }

        Optional<User> user = this.userRepository.findById(userId);

        return Optional.of(UserDto.fromEntity(user.get())).orElseThrow(() -> new EntityNotFoundException("User with ID "+ userId +" not found", ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<UserDto> findAll() {
        return this.userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer userId) {
        if (userId == null) {
            log.error("User ID not is empty");
            return;
        }
        this.userRepository.deleteById(userId);
    }
}
