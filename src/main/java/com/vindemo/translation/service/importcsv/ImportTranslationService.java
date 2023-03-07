package com.vindemo.translation.service.importcsv;


import com.vindemo.translation.framework.common.CsvImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportTranslationService {

  @Autowired
  CsvImporter csvImporter;

  /**
   * Excute Import csv to Postgres
   */
  public void importCsv() {
    try {
      csvImporter.importCsv();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
