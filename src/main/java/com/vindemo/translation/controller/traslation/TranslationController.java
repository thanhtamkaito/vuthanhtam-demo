package com.vindemo.translation.controller.traslation;

import com.vindemo.translation.dto.request.TranslationRequest;
import com.vindemo.translation.dto.response.TranslationResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {


  @GetMapping("/")
  public ResponseEntity<List<TranslationResponse>> listTranslate(
      @ModelAttribute TranslationRequest request) {

    return ResponseEntity.ok().body(null);
  }
}
