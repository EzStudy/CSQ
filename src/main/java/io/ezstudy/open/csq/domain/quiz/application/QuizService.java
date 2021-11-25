package io.ezstudy.open.csq.domain.quiz.application;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {

  private final QuizRepository quizRepository;

  public void create(QuizRequest quizRequest) {
    Quiz quiz = QuizRequestMapper.INSTANCE.toEntity(quizRequest);
    quizRepository.save(quiz);
  }

  public QuizResponse findById(String id) {
    return QuizResponseMapper.INSTANCE.toDto(
        quizRepository.findById(id).orElseThrow(NoSuchElementException::new));
  }

  public List<QuizResponse> findByCategoryId(String categoryId) {
    return QuizResponseMapper.INSTANCE.toDtoList(
        quizRepository.findAllByCategoryId(categoryId).orElseThrow(NoSuchElementException::new));
  }

  public List<QuizResponse> findAll() {
    return QuizResponseMapper.INSTANCE.toDtoList(quizRepository.findAll());
  }

  public void update(QuizRequest quizRequest) {
    Quiz quiz = quizRepository.findById(quizRequest.getId())
        .orElseThrow(NoSuchElementException::new);

    QuizRequestMapper.INSTANCE.updateFromDto(quizRequest, quiz);
  }

  public void delete(String id) {
    Quiz quiz = quizRepository.findById(id).orElseThrow(NoSuchElementException::new);

    if (quiz.isDeleted()) {
      throw new AlreadyDeletedException(""); // global exception
    } else {
      quiz.onDestroy();
    }

  }

}
