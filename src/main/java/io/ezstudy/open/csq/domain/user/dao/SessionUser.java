package io.ezstudy.open.csq.domain.user.dao;

import io.ezstudy.open.csq.domain.user.domain.User;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {

  private String name;
  private String email;
  private String picture;

  public SessionUser(User user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}