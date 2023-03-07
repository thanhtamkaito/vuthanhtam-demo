package com.vindemo.translation.service.translation;


import com.vindemo.translation.dto.response.TranslationResponse;
import com.vindemo.translation.entity.Translations;
import com.vindemo.translation.framework.exception.ValidateException;
import com.vindemo.translation.repository.TranslationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationsService {


  @Autowired
  TranslationRepository translationRepository;

  public List<TranslationResponse> translationResponses(Integer pageNumber, Integer pageSize) {

    validate(pageNumber, pageSize);

    int offset = (pageNumber - 1) * pageSize;
    int limit = pageSize;

    List<Translations> translations = translationRepository.findTranslationsWithLimitAndOffset(
        limit, offset);

    return convert(translations);
  }

  private void validate(Integer pageNumber, Integer pageSize) {

    if (pageNumber < 1) {

      throw new ValidateException("pageNumber must be greater than 1");
    }
    if (pageSize < 1) {

      throw new ValidateException("pageSize must be greater than 1");
    }


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
