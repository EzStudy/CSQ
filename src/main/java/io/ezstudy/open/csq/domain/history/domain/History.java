package io.ezstudy.open.csq.domain.history.domain;

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
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private String action_code;
    private String detail;
    private LocalDateTime created_at;

    @Builder
    public History(long id, long user_id, String action_code, String detail, LocalDateTime created_at){
        this.id = id;
        this.user_id = user_id;
        this.action_code = action_code;
        this.detail = detail;
        this.created_at = created_at;
    }
}
