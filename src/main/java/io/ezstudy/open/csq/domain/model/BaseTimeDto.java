package io.ezstudy.open.csq.domain.model;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class BaseTimeDto implements Serializable {

  protected String createdAt;
  protected String updatedAt;
  protected String deletedAt;

  protected BaseTimeDto() {
  }

  protected BaseTimeDto(String createdAt, String updatedAt, String deletedAt) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }
}