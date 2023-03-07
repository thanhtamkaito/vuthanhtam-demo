package com.vindemo.translation.dto.response;


import lombok.Data;

@Data
public class TranslationResponse {

  private Integer idEng;

  private String textEng;

  private String audioUrl;

  private int idVie;

  private String textVie;

  public TranslationResponse() {

  }
}
