package com.stpdiron.lab4.services;

import com.stpdiron.lab4.dtos.UserDto;
import com.stpdiron.lab4.entities.Role;
import com.stpdiron.lab4.entities.User;
import com.stpdiron.lab4.repositories.RolesRepository;
import com.stpdiron.lab4.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(
                usersRepository.findByUsername(username)
        ).orElseThrow(() -> new UsernameNotFoundException("user not found!"));
    }

    public User createUser(UserDto user) {
        String hash = passwordEncoder.encode(user.getPassword());
        User newUser = new User(user.getUsername(), hash);
        return setRole("ROLE_USER", newUser);
    }

    public User setRole(String roleName, User user) {
        Set<Role> role = rolesRepository.findRolesByName(roleName);
        user.setRoles(role);
        return usersRepository.save(user);
    }

}
