package com.stpdiron.lab4.controllers.rest;

import com.stpdiron.lab4.dtos.Coordinates;
import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.entities.User;
import com.stpdiron.lab4.services.PointsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/points")
@Slf4j
public class PointController {
    private final PointsService pointsService;

    @Autowired
    public PointController(PointsService pointsService) {
        this.pointsService = pointsService;
    }

    @GetMapping
    public List<Point> getPoints(@AuthenticationPrincipal User user) {
        log.info(String.format("User with name %s", user.getUsername()));
        return pointsService.getPointOfUser(user);
    }

    @PutMapping
    public Point makePoint(@Valid @RequestBody Coordinates coordinates, @AuthenticationPrincipal User user) {
        log.info(coordinates.toString());
        return pointsService.processAndSave(coordinates, user);
    }

}
