package io.ezstudy.open.csq.global;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Constants {

  @Getter
  @RequiredArgsConstructor
  public enum ROLE {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
  }

}
