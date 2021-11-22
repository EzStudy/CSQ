package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.dao.CategoryRequestMapper;
import io.ezstudy.open.csq.domain.category.dao.CategoryResponseMapper;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.dto.CategoryRequest;
import io.ezstudy.open.csq.domain.category.dto.CategoryResponse;
import io.ezstudy.open.csq.domain.category.exception.CategoryInUseException;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final QuizService quizService;


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

  public void delete(String id) {
    // category 를 사용중인 quiz 가 있는지 체크
    if (quizService.findByCategoryId(id)) {
      throw new CategoryInUseException("This Category is being used for quiz");
    }

    // 없는 경우 삭제
    categoryRepository.deleteById(id);
  }

}
