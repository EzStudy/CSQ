package io.ezstudy.open.csq.domain.model;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class BaseTimeDto implements Serializable {

  protected String createdAt;
  protected String updatedAt;

  protected BaseTimeDto() {
  }

  protected BaseTimeDto(String createdAt, String updatedAt) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}