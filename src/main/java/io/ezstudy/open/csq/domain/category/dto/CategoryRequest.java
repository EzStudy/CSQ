package io.ezstudy.open.csq.domain.category.dto;

import io.ezstudy.open.csq.domain.model.BaseTimeDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CategoryRequest extends BaseTimeDto {

  private String id;

  private String name;

  protected CategoryRequest() {
  }

  @Builder
  public CategoryRequest(String createdAt, String updatedAt, String deletedAt, String name) {
    super(createdAt, updatedAt, deletedAt);
    this.name = name;
  }

  @Override
  public String toString() {
    return "CategoryRequest{" +
        "id='" + id + '\'' +
        "name='" + name + '\'' +
        '}';
  }
}
