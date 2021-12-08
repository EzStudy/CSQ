package io.ezstudy.open.csq.domain.user.api;

import io.ezstudy.open.csq.domain.user.application.UserService;
import io.ezstudy.open.csq.domain.user.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserApi {

  private final UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody User d) {
    userService.create(d);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable("id") String id) {
    User user = userService.findById(id);
    HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(user, status);
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() { // pagination 필요
    List<User> userList = userService.findAll();
    HttpStatus status = userList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(userList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody User d) {
    userService.update(d);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    userService.delete(id);
  }

}
