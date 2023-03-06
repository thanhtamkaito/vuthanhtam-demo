package com.vindemo.translation.controller.genneratecsv;

import com.vindemo.translation.service.importcsv.ImportTranslationService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ImportTranslationController {


  @Autowired
  ImportTranslationService service;

  @GetMapping("/import")
  public ResponseEntity<String> generateTranslation() throws IOException {

    service.importCsv();

    return ResponseEntity.ok().body("OK");
  }
}
