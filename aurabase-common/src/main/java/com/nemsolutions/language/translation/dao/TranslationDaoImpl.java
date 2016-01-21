package com.nemsolutions.language.translation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemsolutions.auracore.orm.HibernateRepository;
//import com.nemsolutions.language.language.model.Language;
import com.nemsolutions.language.translation.model.Translation;


@Repository
public class TranslationDaoImpl extends HibernateRepository implements TranslationDao {

	@Autowired
	protected TranslationDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Translation getTranslationById(Integer id) {
		Criteria criteria = getSession().createCriteria(Translation.class);
		criteria.add(Restrictions.eq("id", id));
		return (Translation)criteria.uniqueResult();
	}

	@Override
	public void save(Translation translation) {
		getSession().save(translation);
	}
	
	@Override
	public List<Translation> getAllTranslations() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Translation.class);
		@SuppressWarnings("unchecked")
		List<Translation> translations = criteria.list();
		return translations;
	}

	@Override
	public void remove(Integer translationId) {
		Translation object = (Translation)getSession().createCriteria(Translation.class)
		.add(Restrictions.eq("id", translationId)).uniqueResult();
		
		getSession().delete(object);	// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Translation translation) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(translation);
	}
}
