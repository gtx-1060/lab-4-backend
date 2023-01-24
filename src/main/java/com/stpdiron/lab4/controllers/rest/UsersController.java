package com.stpdiron.lab4.controllers.rest;

import com.stpdiron.lab4.dtos.UserDto;
import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.entities.User;
import com.stpdiron.lab4.services.PointsService;
import com.stpdiron.lab4.services.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@Slf4j
public class UsersController {
    private final UserDetailsServiceImpl userDetailsService;
    private final PointsService pointsService;

    @Autowired
    public UsersController(UserDetailsServiceImpl userDetailsService, PointsService pointsService) {
        this.userDetailsService = userDetailsService;
        this.pointsService = pointsService;
    }

    @GetMapping("/{username}/points")
    public List<Point> getPointsOfUser(@AuthenticationPrincipal User user
            , @PathVariable(value = "username") String username) {
        log.info(String.format("User with name %s", user.getUsername()));
        User targetUser = userDetailsService.loadUserByUsername(username);
        return pointsService.getPointOfUser(targetUser);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@Valid @RequestBody UserDto user) {
        return userDetailsService.createUser(user);
    }

    @GetMapping
    public User getSelfProfile(@AuthenticationPrincipal User user) {
        return user;
    }
}
