package io.ezstudy.open.csq.domain.category.dao;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.model.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends GenericMapper<Category, Category> {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}