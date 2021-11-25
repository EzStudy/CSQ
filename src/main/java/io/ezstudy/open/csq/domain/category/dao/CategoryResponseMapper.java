package io.ezstudy.open.csq.domain.category.dao;

import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.dto.CategoryResponse;
import io.ezstudy.open.csq.domain.model.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryResponseMapper extends GenericMapper<CategoryResponse, Category> {

  CategoryResponseMapper INSTANCE = Mappers.getMapper(CategoryResponseMapper.class);

}