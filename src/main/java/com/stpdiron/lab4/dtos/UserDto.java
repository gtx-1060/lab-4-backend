package com.stpdiron.lab4.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class UserDto implements Serializable {

    @Size(min = 3, max = 20, message = "Имя пользователя должно содержать от 3 до 20 символов.")
    private String username;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[^\s]{4,30}",
            message = "Пароль должен содержать одну цифру, заглавную букву и быть не кароче 4 символов.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
