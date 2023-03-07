package com.vindemo.translation.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TranslationRequest {

  private Integer pageNumber;

  private Integer pageSize;
}
