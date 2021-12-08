package io.ezstudy.open.csq.domain.user.application;

import io.ezstudy.open.csq.domain.user.dao.UserMapper;
import io.ezstudy.open.csq.domain.user.dao.UserRepository;
import io.ezstudy.open.csq.domain.user.domain.User;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public void create(User d) {
    userRepository.save(d);
  }

  public User findById(String id) {
    return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public void update(User d) {
    User user = userRepository.findById(d.getId())
        .orElseThrow(NoSuchElementException::new);

    UserMapper.INSTANCE.updateFromDto(d, user);
  }

  public void delete(String id) {
    User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    userRepository.deleteById(id);
  }

}
