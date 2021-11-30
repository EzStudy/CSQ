package io.ezstudy.open.csq.domain.category.application;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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

        categoryService.create(category);

        List<Category> categories = categoryRepository.findByNameContainingIgnoreCase("test");

        System.out.println(categories);
    }
}