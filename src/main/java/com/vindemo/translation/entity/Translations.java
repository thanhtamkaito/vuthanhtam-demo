package com.vindemo.translation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "translations")
public class Translations {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  private Integer idEng;

  @Column(columnDefinition = "text")
  private String textEng;

  private String audioUrl;

  private Integer idVie;

  @Column(columnDefinition = "text")
  private String textVie;

}
