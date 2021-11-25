package io.ezstudy.open.csq.domain.recommend.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private long quiz_id;
    private long comment_id;
    private String type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    @Builder
    public Recommend(long id, long user_id, long quiz_id, long comment_id, String type, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at){
        this.id = id;
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.comment_id = comment_id;
        this.type = type;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }
}
