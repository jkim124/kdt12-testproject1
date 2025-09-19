/*
package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  // Java 16 이상에서 사용할 수 있는 불변 데이터 클래스 record
//    생성자, getter, equals, hashCode, toString을 자동 생성
//    여기서는 예외 메시지를 담는 간단한 DTO 역할
  record ErrorResponse(String message) {}

  // IllegalArgumentException이 발생하면 이 메소드가 호출됨
  @ExceptionHandler(IllegalArgumentException.class)
  // HTTP 상태 코드를 400 Bad Request로 설정
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleIllegalArgumentException(IllegalArgumentException e) {
    return new ErrorResponse(e.getMessage());
  }
}
*/
