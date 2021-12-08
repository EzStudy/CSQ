package io.ezstudy.open.csq.domain.quiz.domain;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "quiz")
@NoArgsConstructor
public class Quiz extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  @Column(length = 36)
  private String userId;

  @ManyToOne
  @JoinColumn(name = "categoryId")
//  @Column(length=36, nullable = false)
  private Category categoryId;

  @NotNull
  @Column(length = 100)
  private String title;

  @NotNull
  private byte[] content;

  @NotNull
  private byte[] multipleChoice;

  @NotNull
  private byte[] answer;

  @NotNull
  private byte[] explanation;

  @NotNull
  @Column(length = 20, nullable = false)
  private String type;
  @Column(length = 11)
  private int recommend;

  @Builder
  public Quiz(String id, String userId, Category categoryId, String title, byte[] content,
      byte[] multipleChoice, byte[] answer, byte[] explanation, String type, int recommend,
      String createdAt, String updatedAt, String deletedAt) {

    super(createdAt, updatedAt, deletedAt);
    this.id = id;
    this.userId = userId;
    this.categoryId = categoryId;
    this.title = title;
    this.content = content;
    this.multipleChoice = multipleChoice;
    this.answer = answer;
    this.explanation = explanation;
    this.type = type;
    this.recommend = recommend;
  }

  @Override
  public String toString() {
    return "Quiz{" +
        "id='" + id + '\'' +
        ", userId='" + userId + '\'' +
        ", categoryId=" + categoryId +
        ", title='" + title + '\'' +
        ", content=" + Arrays.toString(content) +
        ", multipleChoice=" + Arrays.toString(multipleChoice) +
        ", answer=" + Arrays.toString(answer) +
        ", explanation=" + Arrays.toString(explanation) +
        ", type='" + type + '\'' +
        ", recommend=" + recommend +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        ", deletedAt='" + deletedAt + '\'' +
        '}';
  }
}
