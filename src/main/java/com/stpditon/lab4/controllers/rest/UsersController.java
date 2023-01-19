package com.stpditon.lab4.controllers.rest;

import com.stpditon.lab4.dtos.UserDto;
import com.stpditon.lab4.entities.User;
import com.stpditon.lab4.repositories.UsersRepository;
import com.stpditon.lab4.services.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Slf4j
public class UsersController {
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UsersController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody UserDto user) {
        return userDetailsService.createUser(user);
    }
}
