package io.ezstudy.open.csq.domain.quiz.api;

import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name="Quiz API")
@RequiredArgsConstructor
@RequestMapping("/quizes")
//@RestController
@Controller
public class QuizApi {

  private final QuizService quizService;

  @Operation(summary = "퀴즈 목록 화면")
  @GetMapping("/list")
  public String quizList(){
    return "quiz/list";
  }

  @Operation(summary = "퀴즈 생성 화면")
  @GetMapping("/createQuiz")
  public String createQuiz(){
    return "quiz/create";
  }

  @Operation(summary = "퀴즈 생성")
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public void createQuiz(@RequestBody Quiz d) {
    quizService.create(d);
  }

  @Operation(summary = "단일 퀴즈 조회", description = "퀴즈 아이디에 해당하는 퀴즈를 조회합니다.")
  @GetMapping("/{id}")
  public ResponseEntity<Quiz> getQuiz(@PathVariable("id") String id) {
    Quiz quiz = quizService.findById(id);
    HttpStatus status = quiz != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quiz, status);
  }

  @Operation(summary = "카테고리 별 퀴즈 목록 조회", description = "해당 카테고리에 해당하는 퀴즈 목록을 조회합니다.")
  @GetMapping("/categories/{categoryName}")
  public ResponseEntity<List<Quiz>> getQuizsByCategoryName( // pagination 필요
      @PathVariable("categoryName") String categoryName) {
    List<Quiz> quizList = quizService.findAllByCategoryName(categoryName);
    HttpStatus status = quizList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizList, status);
  }

  @Operation(summary = "퀴즈 목록 조회")
  @GetMapping
  public ResponseEntity<List<Quiz>> getQuizs() { // pagination 필요
    List<Quiz> quizList = quizService.findAll();
    HttpStatus status = quizList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(quizList, status);
  }

  @Operation(summary = "퀴즈 업데이트")
  @PatchMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateQuiz(@RequestBody Quiz d) {
    quizService.update(d);
  }

  @Operation(summary = "퀴즈 삭제", description = "퀴즈 아이디에 해당하는 퀴즈를 삭제합니다.")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteQuiz(@PathVariable("id") String id) {
    quizService.deleteById(id);
  }

}
