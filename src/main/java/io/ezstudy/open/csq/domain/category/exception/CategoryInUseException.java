package io.ezstudy.open.csq.domain.category.exception;

public class CategoryInUseException extends RuntimeException {

  // @TODO 공통 예외 처리 만들기
  // https://github.com/cheese10yun/spring-guide/blob/master/docs/exception-guide.md

  public CategoryInUseException(String message) {
    super(message);
  }

}
