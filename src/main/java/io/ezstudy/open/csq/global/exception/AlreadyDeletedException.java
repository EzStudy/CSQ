package io.ezstudy.open.csq.global.exception;

public class AlreadyDeletedException extends RuntimeException {

  // @TODO 공통 예외 처리 만들기
  // https://github.com/cheese10yun/spring-guide/blob/master/docs/exception-guide.md

  public AlreadyDeletedException(String message) {
    super(message);
  }

}
