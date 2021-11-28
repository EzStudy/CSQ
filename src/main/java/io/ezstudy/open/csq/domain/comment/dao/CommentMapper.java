package io.ezstudy.open.csq.domain.comment.dao;

import io.ezstudy.open.csq.domain.comment.domain.Comment;
import io.ezstudy.open.csq.domain.model.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper extends GenericMapper<Comment, Comment> {

  CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
}