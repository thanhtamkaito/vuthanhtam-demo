package com.vindemo.translation.service.translation;


import com.vindemo.translation.dto.request.TranslationRequest;
import com.vindemo.translation.dto.response.TranslationResponse;
import com.vindemo.translation.entity.Translations;
import com.vindemo.translation.repository.TranslationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationsService {


  @Autowired
  TranslationRepository translationRepository;

  public List<TranslationResponse> translationResponses(TranslationRequest request) {

    List<Translations> translations = translationRepository.findTranslationsWithLimitAndOffset(
        request.getPageNumber(),
        request.getPageSize());

    return convert(translations);
  }

  private List<TranslationResponse> convert(List<Translations> translations) {

    List<TranslationResponse> responses = translations.stream().map(translation -> {
      TranslationResponse translationResponses = new TranslationResponse();
      translationResponses.setIdEng(translation.getIdEng());
      translationResponses.setTextEng(translation.getTextEng());
      translationResponses.setAudioUrl(translation.getAudioUrl());
      translationResponses.setIdVie(translation.getIdVie());
      translationResponses.setTextVie(translation.getTextVie());

      return translationResponses;
    }).collect(Collectors.toList());

    return responses;
  }
}
