package io.ezstudy.open.csq.domain.comment.domain;

import io.ezstudy.open.csq.domain.model.BaseTimeEntity;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import java.sql.Blob;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    @GenericGenerator(name ="uuid", strategy="uuid2")
    @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
    private String id;

    private String user_id;

    @ManyToOne
    @JoinColumn(name ="quiz_id")
    private Quiz quiz;

    private byte[] content;
    private int is_correct;

    @Builder
    public Comment(String id, String user_id, Quiz quiz, byte[] content, int is_correct, String created_at, String updated_at, String deleted_at){
        super(created_at, updated_at, deleted_at);

        this.id = id;
        this.user_id = user_id;
        this.quiz = quiz;
        this.content = content;
        this.is_correct = is_correct;
    }
}
