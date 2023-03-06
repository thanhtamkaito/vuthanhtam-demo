package com.vindemo.translation.service.gennerateCsv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GenerateTranslationService {

  private static final Logger logger = LoggerFactory.getLogger(GenerateTranslationService.class);

  private final String SENTENCE_PATH = "F://vinTest/data/CSV-02/sentences.csv";

  private final String SENTENCE_WITH_AUDIO_PATH = "F://vinTest/data/CSV-02/sentences_with_audio.csv";

  private final String LINKS_PATH = "F://vinTest/data/CSV-02/links.csv";

  private final String OUTPUT_PATH = "F://vinTest/data/CSV-02/translation.csv";

  public void generateTranslation() throws IOException {

    Map<Integer, String> listIdEng = new HashMap<>();

    Map<Integer, String> listIdVie = new HashMap<>();

    try (BufferedReader br = new BufferedReader(
        new FileReader(SENTENCE_PATH))) {

      String line;
      while ((line = br.readLine()) != null) {

        String[] fields = line.split("\t");

        int id = Integer.parseInt(fields[0]);

        String langCode = fields[1];

        if (langCode.equals("eng")) {

          String text_Eng = fields[2];

          listIdEng.put(id, text_Eng);


        } else if (langCode.equals("vie")) {

          String text_Vie = fields[2];

          listIdVie.put(id, text_Vie);

        }


      }

    }

    // Load the sentences with audio file
    Map<Integer, String> audioUrls = new HashMap<>();

    try (BufferedReader br = new BufferedReader(
        new FileReader(SENTENCE_WITH_AUDIO_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {

        String[] fields = line.split("\t");

        int id = Integer.parseInt(fields[0]);

        String audioUrl;

        if (fields.length > 3) {
          audioUrl = fields[3];
        } else {
          audioUrl = "";
        }

        audioUrls.put(id, audioUrl);


      }
    }

    // Generate the translation file
    try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_PATH))) {

      //  pw.println("id_eng,text_eng,audio_url,id_vie,text_vie");

      try (BufferedReader br = new BufferedReader(
          new FileReader(LINKS_PATH))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] fields = line.split("\t");

          int idEng = Integer.parseInt(fields[0]);

          int traslationId = Integer.parseInt(fields[1]);

          if (listIdEng.containsKey(idEng) && listIdVie.containsKey(traslationId)) {

            String audioUrl = audioUrls.get(idEng);

            if (audioUrl == null) {
              audioUrl = "";
            } else {
              audioUrl = "https://audio.tatoeba.org/sentences/eng/" + idEng + ".mp3";
            }

            pw.printf("%d\t%s\t%s\t%d\t%s\n", idEng, listIdEng.get(idEng), audioUrl,
                traslationId, listIdVie.get(traslationId));
          }
        }


      }


    }

    logger.info("Translation file generated successfully.");

  }


}




