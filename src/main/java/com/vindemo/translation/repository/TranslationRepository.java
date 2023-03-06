package com.vindemo.translation.repository;

import com.vindemo.translation.entity.Translations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translations, Integer> {

}
