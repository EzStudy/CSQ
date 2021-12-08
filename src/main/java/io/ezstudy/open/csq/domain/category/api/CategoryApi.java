package io.ezstudy.open.csq.domain.category.api;

import io.ezstudy.open.csq.domain.category.application.CategoryService;
import io.ezstudy.open.csq.domain.category.domain.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryApi {

  private final CategoryService categoryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Category category) {
    categoryService.create(category);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findById(@PathVariable("id") String id) {
    Category category = categoryService.findById(id);
    HttpStatus status = category != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(category, status);
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categoryList = categoryService.findAll();
    HttpStatus status = categoryList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(categoryList, status);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<List<Category>> findByNameContainingIgnoreCase(
      @PathVariable("name") String name) {
    List<Category> categoryList = categoryService.findByNameContainingIgnoreCase(name);
    HttpStatus status = categoryList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(categoryList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody Category categoryRequest) {
    categoryService.update(categoryRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    categoryService.delete(id);
  }

}
