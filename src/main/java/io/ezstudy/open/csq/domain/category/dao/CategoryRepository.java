package io.ezstudy.open.csq.domain.category.dao;

import io.ezstudy.open.csq.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByNameContainingIgnoreCase(String name);
}
