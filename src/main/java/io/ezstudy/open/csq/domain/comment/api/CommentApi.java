package io.ezstudy.open.csq.domain.comment.api;

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
@RequestMapping("/api/v1/comments")
@RestController
public class CommentApi {

  private final QuizService commentService;

  /*
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody CommentRequest commentRequest) {
    commentService.create(commentRequest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentResponse> findById(@PathVariable("id") String id) {
    CommentResponse commentResponse = commentService.findById(id);
    HttpStatus status = commentResponse != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(commentResponse, status);
  }

  @GetMapping("/categories/{categoryId}")
  public ResponseEntity<List<CommentResponse>> findByCategoryId( // pagination 필요
      @PathVariable("categoryId") String cateogoryId) {
    List<CommentResponse> commentResponseList = commentService.findByCategoryId(cateogoryId);
    HttpStatus status = commentResponseList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(commentResponse, status);
  }

  @GetMapping
  public ResponseEntity<List<CommentResponse>> findAll() { // pagination 필요
    List<CommentResponse> commentResponseList = commentService.findAll();
    HttpStatus status = commentResponseList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(commentResponseList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody CommentRequest commentRequest) {
    commentService.update(commentRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    commentService.delete(id);
  }
  */
}
