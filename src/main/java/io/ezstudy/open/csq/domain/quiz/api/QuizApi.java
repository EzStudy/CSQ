package io.ezstudy.open.csq.domain.quiz.api;

import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/quizzes")
@RestController
public class QuizApi {

  private final QuizService quizService;

  /*
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody QuizRequest quizRequest) {
    quizService.create(quizRequest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<QuizResponse> findById(@PathVariable("id") String id) {
    QuizResponse quizResponse = quizService.findById(id);
    HttpStatus status = quizResponse != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizResponse, status);
  }

  @GetMapping("/categories/{categoryId}")
  public ResponseEntity<List<QuizResponse>> findByCategoryId( // pagination 필요
      @PathVariable("categoryId") String cateogoryId) {
    List<QuizResponse> quizResponseList = quizService.findByCategoryId(cateogoryId);
    HttpStatus status = quizResponseList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizResponse, status);
  }

  @GetMapping
  public ResponseEntity<List<QuizResponse>> findAll() { // pagination 필요
    List<QuizResponse> quizResponseList = quizService.findAll();
    HttpStatus status = quizResponseList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizResponseList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody QuizRequest quizRequest) {
    quizService.update(quizRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    quizService.delete(id);
  }
  */

}
