package com.vindemo.translation.repository;

import com.vindemo.translation.entity.Translations;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translations, Integer> {


  @Query(value = "SELECT id_eng, text_eng, audio_url, id_vie, text_vie "
      + "FROM translation "
      + "ORDER BY id_eng "
      + "LIMIT ?1 OFFSET ?2", nativeQuery = true)
  List<Translations> findTranslationsWithLimitAndOffset(Integer limitValue, Integer offsetValue);
}
