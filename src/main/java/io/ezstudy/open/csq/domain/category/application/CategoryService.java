package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.dao.CategoryRequestMapper;
import io.ezstudy.open.csq.domain.category.dao.CategoryResponseMapper;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.dto.CategoryRequest;
import io.ezstudy.open.csq.domain.category.dto.CategoryResponse;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public void create(CategoryRequest categoryRequest) {
    Category category = CategoryRequestMapper.INSTANCE.toEntity(categoryRequest);
    categoryRepository.save(category);
  }

  public CategoryResponse findById(String id) {
    return CategoryResponseMapper.INSTANCE.toDto(
        categoryRepository.findById(id).orElseThrow(NoSuchElementException::new));
  }

  public List<CategoryResponse> findAll() {
    return CategoryResponseMapper.INSTANCE.toDtoList(categoryRepository.findAll());
  }

  public CategoryResponse update(CategoryRequest categoryRequest) {
    Category category = CategoryRequestMapper.INSTANCE.toEntity(categoryRequest);
    categoryRepository.save(category);

    return this.findById(category.getId());
  }

  public void delete(String id) {
    Category category = categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    category.onPreDestroy();
  }

}
