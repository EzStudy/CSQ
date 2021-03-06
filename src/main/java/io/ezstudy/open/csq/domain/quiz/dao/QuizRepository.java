package io.ezstudy.open.csq.domain.quiz.dao;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

  List<Quiz> findAllByCategoryId(Category categoryId);

  List<Quiz> findByTitleContainingIgnoreCase(String title);

//  List<Quiz> findAllByCategoryName(String categoryName);
}
