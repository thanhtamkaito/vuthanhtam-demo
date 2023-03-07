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
public class ValidateException extends RuntimeException {


  private Map<String, List<String>> errors = new HashMap<>();

  private List<String> errorMessages = new ArrayList<>();

  public ValidateException(List<String> errorMessages, String name, String message) {
    this.errorMessages = errorMessages;
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public ValidateException(List<String> errorMessages, Map<String, List<String>> errors) {
    this.errorMessages = errorMessages;
    this.errors = errors;
  }

  public ValidateException(String errorMessage, String name, String message) {
    this.errorMessages = Arrays.asList(errorMessage);
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public ValidateException(String errorMessage, Map<String, List<String>> errors) {
    this.errorMessages = Arrays.asList(errorMessage);
    this.errors = errors;
  }


  public ValidateException(String name, String message) {
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public ValidateException(Map<String, List<String>> errors) {
    this.errors = errors;
  }

  public ValidateException(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public ValidateException(String errorMessage) {
    this.errorMessages = Arrays.asList(errorMessage);
  }
}


