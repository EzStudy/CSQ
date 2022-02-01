package io.ezstudy.open.csq.domain.category.api;

import io.ezstudy.open.csq.domain.category.application.CategoryService;
import io.ezstudy.open.csq.domain.category.domain.Category;
import io.ezstudy.open.csq.domain.model.ResponseDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@RequestMapping("/categories")
//@RestController
@Controller
public class CategoryApi {

  private final CategoryService categoryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseDto> create(@RequestBody Category category) {

    Category savedCategory = categoryService.create(category);
    ResponseDto dto = ResponseDto.builder()
        .url("localhost:8080/categories/" + savedCategory.getId())
        .data(savedCategory)
        .build();
    return new ResponseEntity<ResponseDto>(dto,HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseDto> findById(@PathVariable("id") String id) {
    Category category = categoryService.findById(id);
    HttpStatus status = category != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    ResponseDto dto = ResponseDto.builder()
        .url("http://localhost:8080/categories/"+category.getId())
        .data(category)
        .build();
    return new ResponseEntity<>(dto, status);
  }

  @GetMapping
  public ResponseEntity<List<ResponseDto>> findAll() {
    List<Category> categoryList = categoryService.findAll();
    HttpStatus status = categoryList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    List<ResponseDto> dtoList = new ArrayList<>();
    for(Category category : categoryList){
      ResponseDto dto = ResponseDto.builder()
          .url("http://localhost:8080/categories/"+category.getId())
          .data(category)
          .build();
      dtoList.add(dto);
    }
    return new ResponseEntity<>(dtoList, status);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ResponseDto> update(@PathVariable String id, @RequestBody Category categoryRequest) {
    Category savedCategory = categoryService.update(id, categoryRequest);
    ResponseDto dto = ResponseDto.builder()
        .url("http://localhost:8080/categories/"+savedCategory.getId())
        .data(savedCategory)
        .build();
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ResponseDto> delete(@PathVariable("id") String id) {
    if(categoryService.delete(id)){
      return new ResponseEntity<>(new ResponseDto<Category>(), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(new ResponseDto<Category>(), HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ResponseDto> deleteAll(){
    if(categoryService.deleteAll()){
      return new ResponseEntity<>(new ResponseDto<Category>(), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(new ResponseDto(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/createCategory")
  public String createCategory(Model model){
    return "category/create";
  }
}
