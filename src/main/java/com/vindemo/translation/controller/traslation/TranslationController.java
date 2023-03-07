package com.vindemo.translation.controller.traslation;

import com.vindemo.translation.dto.response.TranslationResponse;
import com.vindemo.translation.service.translation.TranslationsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

  @Autowired
  TranslationsService translationsService;


  @GetMapping("/api/translations")
  public ResponseEntity<List<TranslationResponse>> listTranslate(
      @RequestParam(defaultValue = "0") Integer page_number,
      @RequestParam(defaultValue = "10") Integer page_size) {

    return ResponseEntity.ok()
        .body(translationsService.translationResponses(page_number, page_size));
  }
}
