package com.vindemo.translation.framework.exception;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

public interface IBusinessException {

  Optional<HttpStatus> getStatus();

  Optional<String> getResult();

  List<String> getMessageList();
}
