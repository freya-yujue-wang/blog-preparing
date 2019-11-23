package com.example.initializer.Repository;

import com.example.initializer.domain.User;
import java.util.List;


public interface UserRepo {
  User saveOrUpdate(User user);

  void deleteById(Long id);

  User findById(Long id);

  List<User> findAll();
}
