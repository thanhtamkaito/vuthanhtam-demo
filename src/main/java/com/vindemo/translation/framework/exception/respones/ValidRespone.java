package com.vindemo.translation.framework.exception.respones;


import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidRespone {

  private List<String> error;

  private String status;

}
