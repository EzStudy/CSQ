package io.ezstudy.open.csq.domain.category;

import io.ezstudy.open.csq.domain.category.dao.CategoryRepository;
import io.ezstudy.open.csq.domain.category.domain.Category;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest    //이 어노테이션을 통해서 JPA 관련 테스트 설정만 불러올수 있습니다. Datasource 설정이라든가, JPA 관련 테스트를 수행할 수 있습니다.
@ActiveProfiles(value="dev")
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveCategoryTest(){
        Category category = Category.builder()
                                    .name("test")
                                    .build();
        Category savedCategory = categoryRepository.save(category);

        List<Category> selectCategory = categoryRepository.findAll();

        for(Category category1 : selectCategory){
            Assertions.assertEquals(savedCategory.getName(), category1.getName());
        }
    }

    @Test
    public void saveCategoryListTest(){
        List<Category> categoryEntityList = new ArrayList<>();
        for(int i=1;i<3;i++) {
            Category category = Category.builder()
                .name("test"+i)
                .build();
            categoryRepository.save(category);
            categoryEntityList.add(category);
        }
        List<Category> selectCategory = categoryRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));

        for(int i=0;i<selectCategory.size();i++){
            Assertions.assertEquals(selectCategory.get(i).getName(), categoryEntityList.get(i).getName());
        }
    }
}
