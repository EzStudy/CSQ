package io.ezstudy.open.csq.domain.category.api;

import io.ezstudy.open.csq.domain.category.application.CategoryService;
import io.ezstudy.open.csq.domain.category.dto.CategoryRequest;
import io.ezstudy.open.csq.domain.category.dto.CategoryResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  public void create(@RequestBody CategoryRequest categoryRequest) {
    categoryService.create(categoryRequest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponse> findById(@PathVariable("id") String id) {
    CategoryResponse categoryResponse = categoryService.findById(id);
    HttpStatus status = categoryResponse != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(categoryResponse, status);
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<List<CategoryResponse>> findAll() {
    List<CategoryResponse> categoryResponseList = categoryService.findAll();
    HttpStatus status = categoryResponseList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(categoryResponseList, status);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public CategoryResponse update(@RequestBody CategoryRequest categoryRequest) {
    return categoryService.update(categoryRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") String id) {
    categoryService.delete(id);
  }
}
