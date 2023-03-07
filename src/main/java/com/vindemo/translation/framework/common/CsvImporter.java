package com.vindemo.translation.framework.common;

import com.vindemo.translation.entity.Translations;
import com.vindemo.translation.repository.TranslationRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CsvImporter {

  @Value("${file.config.properties.translation}")
  private static String CSV_FILE_PATH;

  @Autowired
  private TranslationRepository translationRepository;

  @Transactional
  public void importCsv() throws Exception {

    List<Translations> translationsList = new ArrayList<>();

    // Load translation file
    try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {

        String[] fields = line.split("\t");

        Translations translation = new Translations();

        translation.setIdEng(Integer.parseInt(fields[0]));
        translation.setTextEng(fields[1]);
        translation.setAudioUrl(fields[2]);
        translation.setIdVie(Integer.parseInt(fields[3]));
        translation.setTextVie(fields[4]);

        translationsList.add(translation);
        
      }
    }

    translationRepository.saveAll(translationsList);


  }
}
