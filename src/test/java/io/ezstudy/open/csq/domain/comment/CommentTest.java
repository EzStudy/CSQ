package io.ezstudy.open.csq.domain.comment;

import io.ezstudy.open.csq.domain.comment.dao.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest    //이 어노테이션을 통해서 JPA 관련 테스트 설정만 불러올수 있습니다. Datasource 설정이라든가, JPA 관련 테스트를 수행할 수 있습니다.
@ActiveProfiles(value="dev")
public class CommentTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void saveCommentTest(){

    }
}
