package com.nemsolutions.language.translation.dao;

import java.util.List;

import com.nemsolutions.language.translation.model.Translation;

public interface TranslationDao{
	Translation getTranslationById(Integer id);
	void save(Translation translation);
	List<Translation> getAllTranslations();
	void remove(Integer languageId);
	void update(Translation translation);
}