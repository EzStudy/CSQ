package io.ezstudy.open.csq.domain.quiz.dao;

import io.ezstudy.open.csq.domain.comment.domain.Comment;
import io.ezstudy.open.csq.domain.model.GenericMapper;
import io.ezstudy.open.csq.domain.quiz.domain.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuizMapper extends GenericMapper<Quiz, Quiz> {

  QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);
}