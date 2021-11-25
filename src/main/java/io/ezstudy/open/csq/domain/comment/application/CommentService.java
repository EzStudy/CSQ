package io.ezstudy.open.csq.domain.comment.application;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

  private final CommentRepository commentRepository;

  public void create(CommentRequest commentRequest) {
    Comment comment = CommentRequestMapper.INSTANCE.toEntity(commentRequest);
    commentRepository.save(comment);
  }

  public CommentResponse findById(String id) {
    return CommentResponseMapper.INSTANCE.toDto(
        commentRepository.findById(id).orElseThrow(NoSuchElementException::new));
  }

  public List<CommentResponse> findByCategoryId(String categoryId) {
    return CommentResponseMapper.INSTANCE.toDtoList(
        commentRepository.findAllByCategoryId(categoryId).orElseThrow(NoSuchElementException::new));
  }

  public List<CommentResponse> findAll() {
    return CommentResponseMapper.INSTANCE.toDtoList(commentRepository.findAll());
  }

  public void update(CommentRequest commentRequest) {
    Comment comment = commentRepository.findById(commentRequest.getId())
        .orElseThrow(NoSuchElementException::new);

    CommentRequestMapper.INSTANCE.updateFromDto(commentRequest, comment);
  }

  public void delete(String id) {
    Comment comment = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);

    if (1 == comment.getDeletedAt()) {
      throw new AlreadyCommentDeletedException("");
    }

    comment.onDestroy();
  }

}
