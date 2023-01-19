package com.stpditon.lab4.repositories;

import com.stpditon.lab4.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
