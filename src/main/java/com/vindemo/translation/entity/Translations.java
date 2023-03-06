package com.vindemo.translation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Translations {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  private int idEng;

  @Column(columnDefinition = "text")
  private String textEng;

  private String audioUrl;

  private int idVie;

  @Column(columnDefinition = "text")
  private String textVie;

}
