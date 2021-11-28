package io.ezstudy.open.csq.domain.quiz.dao;

import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

  List<Quiz> findAllByCategoryId(String categoryId);
}
