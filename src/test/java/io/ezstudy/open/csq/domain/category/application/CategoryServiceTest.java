package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findByNameContainingIgnoreCase() {
        String id = UUID.randomUUID().toString();
        Category category = Category.builder()
                .id(id)
                .name("TestCategory")
                .build();

        categoryService.save(category);

        List<Category> categories = categoryRepository.findByNameContainingIgnoreCase("test");

        System.out.println(categories);
    }
}