package io.ezstudy.open.csq.domain.quiz.application;

import io.ezstudy.open.csq.domain.quiz.dao.QuizMapper;
import io.ezstudy.open.csq.domain.quiz.dao.QuizRepository;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import io.ezstudy.open.csq.global.exception.AlreadyDeletedException;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {

  private final QuizRepository quizRepository;

  public void create(Quiz d) {
    quizRepository.save(d);
  }

  public Quiz findById(String id) {
    return quizRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<Quiz> findByTitleContainingIgnoreCase(String title) {
    return quizRepository.findByTitleContainingIgnoreCase(title);
  }

  public List<Quiz> findAllByCategoryId(String categoryId) {
    return quizRepository.findAllByCategoryId(categoryId);
  }

  public List<Quiz> findAllByCategoryName(String categoryName) {
    return quizRepository.findAllByCategoryName(categoryName);
  }

  public List<Quiz> findAll() {
    return quizRepository.findAll();
  }

  public void update(Quiz d) {
    Quiz quiz = quizRepository.findById(d.getId())
        .orElseThrow(NoSuchElementException::new);

    QuizMapper.INSTANCE.updateFromDto(d, quiz);
  }

  public void deleteById(String id) {
    Quiz quiz = quizRepository.findById(id).orElseThrow(NoSuchElementException::new);

    if (null != quiz.getDeletedAt()) {
      throw new AlreadyDeletedException("Quiz is already deleted");
    }

    quiz.onDestroy();
  }

}
