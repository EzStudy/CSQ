package io.ezstudy.open.csq.domain.comment.api;

import io.ezstudy.open.csq.domain.comment.application.CommentService;
import io.ezstudy.open.csq.domain.comment.domain.Comment;
import io.ezstudy.open.csq.domain.comment.dto.CommentDto;
import io.ezstudy.open.csq.domain.oauth.config.auth.SessionUser;
import io.ezstudy.open.csq.domain.quiz.dao.QuizRepository;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import io.ezstudy.open.csq.domain.user.dao.UserRepository;
import io.ezstudy.open.csq.domain.user.domain.User;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
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
  private final UserRepository userRepository;
  private final HttpSession httpSession;
  private final QuizRepository quizRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> create(@RequestBody CommentDto commentDto) {
    SessionUser user = (SessionUser) httpSession.getAttribute("user");
    Optional<User> sessionUser = userRepository.findByEmail(user.getEmail());

    Optional<Quiz> requestQuiz = quizRepository.findById(commentDto.getQuizId());
    if(requestQuiz.isEmpty()){
      return new ResponseEntity<>("Quiz is Empty", HttpStatus.NOT_FOUND);
    }
    Comment comment = Comment.builder()
                                  .userId(sessionUser.get())
                                  .quiz(requestQuiz.get())
                                  .content(commentDto.getContent())
                                  .recommand(commentDto.getRecommand())
                                  .build();
    commentService.create(comment);
    return new ResponseEntity<>("Create Comment", HttpStatus.OK);
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
  public ResponseEntity<String> update(@RequestBody CommentDto commentDto) {
    SessionUser user = (SessionUser) httpSession.getAttribute("user");
    if(user == null){
      return new ResponseEntity<>("No User", HttpStatus.NOT_FOUND);
    }
    Comment savedComment = commentService.findById(commentDto.getId());
    if(commentDto.getContent() !=null){
      savedComment.setContent(commentDto.getContent());
    }else{
      return new ResponseEntity<>("Can not Update comment", HttpStatus.NOT_FOUND);
    }
    commentService.create(savedComment);

    return new ResponseEntity<>("Update Comment content", HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> delete(@PathVariable("id") String id) {
    commentService.delete(id);
    return new ResponseEntity<>("Delete "+id+"comment", HttpStatus.OK);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteAllComment(){
    commentService.deleteAllComment();
    return new ResponseEntity<>("Delete All Comment", HttpStatus.OK);
  }
}
