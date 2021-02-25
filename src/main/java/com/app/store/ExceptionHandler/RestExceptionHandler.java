package com.app.store.ExceptionHandler;

import com.app.store.entity.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public void handleBookNotFoundException() {}
}
