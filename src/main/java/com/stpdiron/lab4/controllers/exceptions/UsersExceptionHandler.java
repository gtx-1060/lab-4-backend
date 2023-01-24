package com.stpdiron.lab4.controllers.exceptions;

import com.stpdiron.lab4.controllers.rest.UsersController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackageClasses = {UsersController.class})
public class UsersExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class })
    public ResponseEntity<String> handleDuplicateInUsersInDb() {
        return new ResponseEntity<>("Пользователь с таким именем уже существует.", HttpStatus.CONFLICT);
    }

}
