package com.homebakery.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(MethodArgumentNotValidException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
 public Map<String,Object> validation(MethodArgumentNotValidException e){
  String msg=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).collect(Collectors.joining(", "));
  return Map.of("error",msg);
 }
 @ExceptionHandler(IllegalArgumentException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
 public Map<String,String> illegal(IllegalArgumentException e){return Map.of("error",e.getMessage());}
}
