package io.ezstudy.open.csq.domain.quiz.domain;

import java.sql.Blob;
import java.sql.Time;
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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private long category_id;
    private String title;
    @Lob
    private Blob content;
    @Lob
    private Blob multiple_choice;
    @Lob
    private Blob answer;
    @Lob
    private Blob explanation;
    private String type;
    private long recommend;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    @Builder
    public Quiz(long id, long user_id, long category_id, String title, Blob content, Blob multiple_choice
                , Blob answer, Blob explanation, String type, long recommend, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at){
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
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }
}
