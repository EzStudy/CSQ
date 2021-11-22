package io.ezstudy.open.csq.domain.category.dao;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.dto.CategoryRequest;
import io.ezstudy.open.csq.domain.model.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryRequestMapper extends GenericMapper<CategoryRequest, Category> {

  CategoryRequestMapper INSTANCE = Mappers.getMapper(CategoryRequestMapper.class);

}