package io.ezstudy.open.csq.domain.category.dto;

import io.ezstudy.open.csq.domain.model.BaseTimeDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CategoryRequest extends BaseTimeDto {

  private String name;

  protected CategoryRequest() {
  }

  @Builder
  public CategoryRequest(String createdAt, String updatedAt, String name) {
    super(createdAt, updatedAt);
    this.name = name;
  }

  @Override
  public String toString() {
    return "CategoryRequest{" +
        "name='" + name + '\'' +
        '}';
  }
}
