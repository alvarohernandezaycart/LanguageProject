package com.nemsolutions.aurabase.components.generic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemsolutions.aurabase.components.generic.model.Test2;
import com.nemsolutions.auracore.orm.HibernateRepository;

@Repository
public class Test2DaoImpl extends HibernateRepository implements Test2Dao {

	@Autowired
	protected Test2DaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Test2 getTestById(Integer id) {
		Criteria criteria = getSession().createCriteria(Test2.class);
		criteria.add(Restrictions.eq("id", id));
		return (Test2)criteria.uniqueResult();
	}

	@Override
	public void save(Test2 test2) {
		getSession().save(test2);
	}

	@Override
	public List<Test2> getAllTests() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Test2.class);
		@SuppressWarnings("unchecked")
		List<Test2> tests = criteria.list();
		return tests;
	}

	@Override
	public void remove(Integer testId) {
		Test2 object = (Test2)getSession().createCriteria(Test2.class)
		.add(Restrictions.eq("id", testId)).uniqueResult();
		
		getSession().delete(object);	// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Test2 test) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(test);
	}
}
