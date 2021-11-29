package io.ezstudy.open.csq.domain.comment.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  @Column(length=36)
  private String userId;

  @ManyToOne
  @JoinColumn(name = "quizId")
  @Column(length=36, nullable = false)
  private Quiz quiz;

  private byte[] content;

  @Column(length=11)
  private int recommand;

  @Builder
  public Comment(String id, String userId, Quiz quiz, byte[] content, int recommand,
      String createdAt, String updatedAt, String deletedAt) {
    super(createdAt, updatedAt, deletedAt);

    this.id = id;
    this.userId = userId;
    this.quiz = quiz;
    this.content = content;
    this.recommand = recommand;
  }
}
