package io.ezstudy.open.csq.domain.category.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name="category")
@NoArgsConstructor
public class Category extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  @NotNull
  @Column(length = 50, nullable = false, unique = true)
  private String name;

  @Builder
  public Category(String createdAt, String updatedAt, String deletedAt, String name, String id) {
    super(createdAt, updatedAt, deletedAt);
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Category{" +
        "name='" + name + '\'' +
        '}';
  }
}
