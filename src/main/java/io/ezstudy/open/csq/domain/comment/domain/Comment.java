package io.ezstudy.open.csq.domain.comment.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import io.ezstudy.open.csq.domain.user.domain.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
  private String id;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User userId;

  @ManyToOne
  @JoinColumn(name = "quizId")
  private Quiz quiz;

  private byte[] content;

  @Column(length=11)
  private int recommand;

  @Builder
  public Comment(String id, User userId, Quiz quiz, byte[] content, int recommand,
      String createdAt, String updatedAt, String deletedAt) {
    super(createdAt, updatedAt, deletedAt);

    this.id = id;
    this.userId = userId;
    this.quiz = quiz;
    this.content = content;
    this.recommand = recommand;
  }
}
