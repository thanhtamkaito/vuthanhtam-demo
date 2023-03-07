package com.vindemo.translation.framework.handler;


import com.vindemo.translation.framework.exception.BusinessRuntimeException;
import com.vindemo.translation.framework.exception.IBusinessException;
import com.vindemo.translation.framework.exception.ValidateException;
import com.vindemo.translation.framework.exception.respones.ValidRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


  @ExceptionHandler(ValidateException.class)
  public ResponseEntity<ValidRespone> handleValidateException(ValidateException exception) {

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidRespone.builder()
        .status("400")
        .error(exception.getErrorMessages())
        .build());
  }

  @ExceptionHandler(BusinessRuntimeException.class)
  public ResponseEntity<ValidRespone> handleBusinessException(Exception e) {
    logger.error("handleBusinessException: " + e.getMessage());

    IBusinessException be = (IBusinessException) e;
    HttpStatus status = be.getStatus().orElse(HttpStatus.BAD_REQUEST);
    String result = be.getResult().orElse(null);
    ValidRespone errResponse;

    return ResponseEntity.status(status).body(ValidRespone.builder()
        .status("500")
        .error(((IBusinessException) e).getMessageList())
        .build());
  }
}