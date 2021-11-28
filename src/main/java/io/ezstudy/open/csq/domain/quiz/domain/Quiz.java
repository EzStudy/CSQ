package io.ezstudy.open.csq.domain.quiz.domain;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@NoArgsConstructor
public class Quiz extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  private String user_id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category_id;

  @NotNull
  private String title;

  @NotNull
  private byte[] content;

  @NotNull
  private byte[] multiple_choice;

  @NotNull
  private byte[] answer;

  @NotNull
  private byte[] explanation;

  @NotNull
  private String type;
  private int recommend;

  @Builder
  public Quiz(String id, String user_id, Category category_id, String title, byte[] content,
      byte[] multiple_choice, byte[] answer, byte[] explanation, String type, int recommend,
      String createdAt, String updatedAt, String deletedAt) {

    super(createdAt, updatedAt, deletedAt);
    this.id = id;
    this.user_id = user_id;
    this.category_id = category_id;
    this.title = title;
    this.content = content;
    this.multiple_choice = multiple_choice;
    this.answer = answer;
    this.explanation = explanation;
    this.type = type;
    this.recommend = recommend;
  }
}
