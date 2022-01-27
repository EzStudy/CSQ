package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryMapper;
import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import io.ezstudy.open.csq.global.exception.UsedException;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final QuizService quizService;

  public Category save(Category d) {
    return categoryRepository.save(d);
  }

  public Category findById(String id) {
    return categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public List<Category> findByNameContainingIgnoreCase(String name) {
    return categoryRepository.findByNameContainingIgnoreCase(name);
  }

  public void update(Category d) {
    Category category = categoryRepository.findById(d.getId())
        .orElseThrow(NoSuchElementException::new);
    CategoryMapper.INSTANCE.updateFromDto(d, category);
  }

  public void deleteById(String id) {
    // category 를 사용중인 quiz 가 있는지 체크
    if (null != quizService.findAllByCategoryName(id)) {
      throw new UsedException("Category is used in quiz yet");
    }

    // 없는 경우 삭제
    categoryRepository.deleteById(id);
  }

}
