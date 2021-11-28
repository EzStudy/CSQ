package io.ezstudy.open.csq.domain.comment.application;

import io.ezstudy.open.csq.domain.comment.dao.CommentMapper;
import io.ezstudy.open.csq.domain.comment.dao.CommentRepository;
import io.ezstudy.open.csq.domain.comment.domain.Comment;
import io.ezstudy.open.csq.global.exception.AlreadyDeletedException;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

  private final CommentRepository commentRepository;

  public void create(Comment d) {
    commentRepository.save(d);
  }

  public Comment findById(String id) {
    return commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<Comment> findAll() {
    return commentRepository.findAll();
  }

  public void update(Comment d) {
    Comment comment = commentRepository.findById(d.getId())
        .orElseThrow(NoSuchElementException::new);

    CommentMapper.INSTANCE.updateFromDto(comment, d);
  }

  public void delete(String id) {
    Comment comment = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);

    if (null != comment.getDeletedAt()) {
      throw new AlreadyDeletedException("Comment is already deleted");
    }

    comment.onDestroy();
  }

}
