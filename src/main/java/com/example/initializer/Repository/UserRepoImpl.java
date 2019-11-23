package com.example.initializer.Repository;

import com.example.initializer.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepoImpl implements UserRepo {
  private ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
  private AtomicLong userId = new AtomicLong();

  @Override
  public User saveOrUpdate(User user) {
    if (user.getId() == null) {
      user.setId(userId.incrementAndGet());
    }
    users.put(user.getId(), user);
    return user;
  }

  @Override
  public void deleteById(Long id) {
    users.remove(id);
  }

  @Override
  public User findById(Long id) {
    return users.getOrDefault(id, null);
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(users.values());
  }
}
