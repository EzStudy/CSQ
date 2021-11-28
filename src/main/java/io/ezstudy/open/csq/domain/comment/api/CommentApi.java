package io.ezstudy.open.csq.domain.comment.api;

import io.ezstudy.open.csq.domain.comment.application.CommentService;
import io.ezstudy.open.csq.domain.comment.domain.Comment;
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

  private final CommentService commentService;


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Comment comment) {
    commentService.create(comment);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Comment> findById(@PathVariable("id") String id) {
    Comment comment = commentService.findById(id);
    HttpStatus status = comment != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(comment, status);
  }

  @GetMapping
  public ResponseEntity<List<Comment>> findAll() { // pagination 필요
    List<Comment> commentList = commentService.findAll();
    HttpStatus status = commentList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(commentList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody Comment comment) {
    commentService.update(comment);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    commentService.delete(id);
  }

}
