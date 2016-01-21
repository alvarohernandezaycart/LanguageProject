package com.nemsolutions.language.translation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nemsolutions.language.translation.dao.TranslationDao;
import com.nemsolutions.language.translation.dto.TranslationDetail;
import com.nemsolutions.language.translation.model.Translation;

@Service
@Transactional
public class TranslationService {
	
	private TranslationDao traslationDao;
	
	@Autowired
	public void setTranslationDao(TranslationDao TranslationDao) {
		this.traslationDao = TranslationDao;
	}
	
	public TranslationDetail getTranslation(Integer translationId){
		Translation t = traslationDao.getTranslationById(translationId);
		TranslationDetail td = new TranslationDetail(t.getId_translation(), t.getKey(), t.getValue(), t.getCreationDate(), t.getModificationDate(), t.getId_app(), t.getId_language());
		return td;
	}
	
	public void saveAllTranslations(List<Translation> translations){
		for(Translation translation : translations){
			traslationDao.save(translation);
		}
	}
	
	public List<TranslationDetail> getAllTranslations(){
		List<Translation> translations = traslationDao.getAllTranslations();
		List<TranslationDetail> tds = new ArrayList<TranslationDetail>();
		for (Translation t : translations) {
			TranslationDetail td = new TranslationDetail(t.getId_translation(), t.getKey(), t.getValue(), t.getCreationDate(), t.getModificationDate(), t.getId_app(), t.getId_language());
			tds.add(td);
		}
		return tds;
	}
	
	public boolean remove(Integer translationId) {
		try {//Acordarse de on delete cascade

			traslationDao.remove(translationId);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void saveTranslation(Integer id_translation, String key, String value, Date creationDate, Date modificationDate,	Integer id_app, Integer id_language) {

		Translation translation = new Translation(key, value, creationDate, modificationDate,id_app, id_language);
		traslationDao.save(translation);
	}
	
	public void updateTranslation(Integer id_translation, String key, String value, Date creationDate, Date modificationDate,	Integer id_app, Integer id_language) {
		Translation translation = new Translation(key, value, creationDate, modificationDate,id_app, id_language);
		traslationDao.update(translation);
	}
}