package io.ezstudy.open.csq.domain.quiz.api;

import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@RequestMapping("/quizes")
//@RestController
@Controller
public class QuizApi {

  private final QuizService quizService;

  @GetMapping("/list")
  public String quizList(){
    return "quiz/list";
  }

  @GetMapping("/createQuiz")
  public String createQuiz(){
    return "quiz/create";
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public void createQuiz(@RequestBody Quiz d) {
    quizService.create(d);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Quiz> getQuiz(@PathVariable("id") String id) {
    Quiz quiz = quizService.findById(id);
    HttpStatus status = quiz != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quiz, status);
  }

  @GetMapping("/categories/{categoryId}")
  public ResponseEntity<List<Quiz>> getQuizsByCategoryId( // pagination 필요
      @PathVariable("categoryId") String categoryId) {
    List<Quiz> quizList = quizService.findAllByCategoryId(categoryId);
    HttpStatus status = quizList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizList, status);
  }

  @GetMapping
  public ResponseEntity<List<Quiz>> getQuizs() { // pagination 필요
    List<Quiz> quizList = quizService.findAll();
    HttpStatus status = quizList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizList, status);
  }

  @PatchMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateQuiz(@RequestBody Quiz d) {
    quizService.update(d);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteQuiz(@PathVariable("id") String id) {
    quizService.deleteById(id);
  }

}
