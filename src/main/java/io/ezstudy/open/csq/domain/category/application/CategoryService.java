package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.category.dto.CategoryRequest;
import io.ezstudy.open.csq.domain.category.dto.CategoryResponse;
import io.ezstudy.open.csq.domain.category.exception.CategoryInUseException;
import io.ezstudy.open.csq.domain.quiz.application.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

//    @Autowired
//    QuizService quizService;

    @Transactional
    public void create(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(String id) {
        return categoryRepository.getById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

//    public void delete(String id) {
//        if(null != quizService.findByCategoryId(id)){
//            throw new CategoryInUseException("This Category is being used for quiz");
//        }
//        categoryRepository.deleteById(id);
//    }
}
