package com.vindemo.translation.framework.exception;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException {


  private Map<String, List<String>> errors = new HashMap<>();

  private List<String> errorMessages = new ArrayList<>();

  public BusinessException(List<String> errorMessages, String name, String message) {
    this.errorMessages = errorMessages;
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public BusinessException(List<String> errorMessages, Map<String, List<String>> errors) {
    this.errorMessages = errorMessages;
    this.errors = errors;
  }

  public BusinessException(String errorMessage, String name, String message) {
    this.errorMessages = Arrays.asList(errorMessage);
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public BusinessException(String errorMessage, Map<String, List<String>> errors) {
    this.errorMessages = Arrays.asList(errorMessage);
    this.errors = errors;
  }

  public BusinessException(String name, String message) {
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public BusinessException(Map<String, List<String>> errors) {
    this.errors = errors;
  }

  public BusinessException(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public BusinessException(String errorMessage) {
    this.errorMessages = Arrays.asList(errorMessage);
  }
}


