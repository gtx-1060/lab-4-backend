package com.stpditon.lab4.services;

import com.stpditon.lab4.dtos.UserDto;
import com.stpditon.lab4.entities.User;
import com.stpditon.lab4.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(
                usersRepository.findByUsername(username)
        ).orElseThrow(() -> new UsernameNotFoundException("user not found!"));
    }

    public User createUser(UserDto user) {
        String hash = passwordEncoder.encode(user.getPassword());
        return usersRepository.save(new User(user.getUsername(), hash));
    }

}
