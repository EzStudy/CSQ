package io.ezstudy.open.csq.domain.user.dao;

import io.ezstudy.open.csq.domain.model.GenericMapper;
import io.ezstudy.open.csq.domain.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends GenericMapper<User, User> {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}