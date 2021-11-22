package io.ezstudy.open.csq.domain.category.dto;

import io.ezstudy.open.csq.domain.model.BaseTimeDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CategoryResponse extends BaseTimeDto {

  private String name;

  protected CategoryResponse() {
  }

  @Builder
  public CategoryResponse(String createdAt, String updatedAt, String name) {
    super(createdAt, updatedAt);
    this.name = name;
  }

  @Override
  public String toString() {
    return "CategoryResponse{" +
        "name='" + name + '\'' +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        '}';
  }
}
