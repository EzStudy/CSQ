package io.ezstudy.open.csq.domain.quiz;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.quiz.dao.QuizRepository;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import java.io.InputStream;
import java.util.List;
import org.hibernate.type.BlobType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest    //이 어노테이션을 통해서 JPA 관련 테스트 설정만 불러올수 있습니다. Datasource 설정이라든가, JPA 관련 테스트를 수행할 수 있습니다.
@ActiveProfiles(value="dev")
public class QuizTest {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveQuizTest(){
        Category category = Category.builder()
            .name("test")
            .build();
        Category savedCategory = categoryRepository.save(category);
        List<Category> categoryList = categoryRepository.findAll();

        Quiz quiz = Quiz.builder()
                        .categoryId(category)
                        .title("quiz_title")
                        .content("quiz_content".getBytes())
                        .multipleChoice("multiple_choice".getBytes())
                        .answer("answer".getBytes())
                        .answer("quiz_explanation".getBytes())
                        .type("quiz_type")
                        .recommend(1)
                        .userId("user_id")
                        .build();

        Quiz savedQuiz = quizRepository.save(quiz);

        List<Quiz> quizList = quizRepository.findAll();

        for(Quiz q : quizList){
            Assertions.assertEquals(q.getTitle(),quiz.getTitle());
            Assertions.assertEquals(q.getCategoryId().getName(), savedCategory.getName());
        }
    }
}
