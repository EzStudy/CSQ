package io.ezstudy.open.csq.domain.comment.dao;

import io.ezstudy.open.csq.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

    List<Comment> findByUserId(String userId);

    List<Comment> findByQuizId(String quizId);
}
