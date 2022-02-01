package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryMapper;
import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import io.ezstudy.open.csq.domain.quiz.dao.QuizRepository;
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
  private final QuizRepository quizRepository;

  public Category create(Category d) {
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

  public Category update(String id, Category d) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(NoSuchElementException::new);
    //CategoryMapper.INSTANCE.updateFromDto(d, category);
    Category savedCategory = Category.builder()
        .id(id)
        .name(d.getName())
        .build();
    return categoryRepository.save(savedCategory);
  }

  public boolean delete(String categoryId) {
    // category 를 사용중인 quiz 가 있는지 체크
    Category category = categoryRepository.findById(categoryId).get();
    if (quizService.findAllByCategoryId(category).isEmpty()) {

      // 없는 경우 삭제
      categoryRepository.deleteById(category.getId());
      return true;
    }
    throw new UsedException("Quiz is exist");
  }

  public boolean deleteAll() {
    if(quizRepository.count()>0){
      throw new UsedException("Quiz is not empty");
    }else{
      categoryRepository.deleteAll();
      return true;
    }
  }
}
