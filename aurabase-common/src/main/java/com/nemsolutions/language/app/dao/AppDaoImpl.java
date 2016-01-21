package com.nemsolutions.language.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemsolutions.auracore.orm.HibernateRepository;
import com.nemsolutions.language.app.model.App;


@Repository
public class AppDaoImpl extends HibernateRepository implements AppDao {

	@Autowired
	protected AppDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public App getAppById(Integer id) {
		Criteria criteria = getSession().createCriteria(App.class);
		criteria.add(Restrictions.eq("id", id));
		return (App)criteria.uniqueResult();
	}

	@Override
	public void save(App app) {
		getSession().save(app);
	}
	
	@Override
	public List<App> getAllApps() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(App.class);
		@SuppressWarnings("unchecked")
		List<App> apps = criteria.list();
		return apps;
	}

	@Override
	public void remove(Integer appId) {
		App object = (App)getSession().createCriteria(App.class)
		.add(Restrictions.eq("id", appId)).uniqueResult();
		
		getSession().delete(object);	// TODO Auto-generated method stub
		
	}

	@Override
	public void update(App app) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(app);
	}
}
