package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryMapper;
import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.exception.CategoryInUseException;
import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final QuizService quizService;

  public void create(Category d) {
    categoryRepository.save(d);
  }

  public Category findById(String id) {
    return categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public void update(Category d) {
    Category category = categoryRepository.findById(d.getId())
        .orElseThrow(NoSuchElementException::new);
    CategoryMapper.INSTANCE.updateFromDto(d, category);
  }

  public void delete(String id) {
    // category 를 사용중인 quiz 가 있는지 체크
    if (null != quizService.findAllByCategoryId(id)) {
      throw new CategoryInUseException("Category is used in quiz yet");
    }

    // 없는 경우 삭제
    categoryRepository.deleteById(id);
  }

}
