package com.vindemo.translation.controller.genneratecsv;


import com.vindemo.translation.service.gennerateCsv.GenerateTranslationService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateTranslationController {


  @Autowired
  GenerateTranslationService service;

  @GetMapping("/generate/eng-vi")
  public ResponseEntity<String> generateTranslation() throws IOException {

    service.generateTranslation();

    return ResponseEntity.ok().body("OK");
  }
}
