package io.ezstudy.open.csq.domain.submit_history.domain;

import java.sql.Blob;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class SubmitHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private long quiz_id;
    @Lob
    private Blob submit_content;
    private int is_correct;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    @Builder
    public SubmitHistory(long id, long user_id, long quiz_id, Blob submit_content, int is_correct, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at){
        this.id = id;
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.submit_content = submit_content;
        this.is_correct = is_correct;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }
}
