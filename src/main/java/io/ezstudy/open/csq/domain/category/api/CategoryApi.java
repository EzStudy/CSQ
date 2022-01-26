package io.ezstudy.open.csq.domain.category.api;

import io.ezstudy.open.csq.domain.category.application.CategoryService;
import io.ezstudy.open.csq.domain.category.domain.Category;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryApi {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categoryList = categoryService.findAll();
    return ResponseEntity.ok(categoryList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findById(@PathVariable("id") String id) {
    Category categoryResponseDto = categoryService.findById(id);
    return ResponseEntity.ok(categoryResponseDto);
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category createCategoryDto) {
    log.debug("category: {}", createCategoryDto.toString());
    Category categoryResponseDto = categoryService.save(createCategoryDto);
    return ResponseEntity.created(URI.create("/categories")).body(categoryResponseDto);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Category categoryUpdateDto) {
    categoryService.update(categoryUpdateDto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") String id) {
    categoryService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
