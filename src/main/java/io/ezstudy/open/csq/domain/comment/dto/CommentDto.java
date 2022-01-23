package io.ezstudy.open.csq.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class CommentDto {
    public String id;
    public String quizId;
    public byte[] content;
    public int recommand;

    @Builder
    public CommentDto(String id, String quizId, byte[] content, int recommand){
        this.id = id;
        this.quizId = quizId;
        this.content = content;
        this.recommand = recommand;
    }
}
