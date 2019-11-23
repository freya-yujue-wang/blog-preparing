package com.example.initializer.Repository;

import com.example.initializer.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Long> {
}
