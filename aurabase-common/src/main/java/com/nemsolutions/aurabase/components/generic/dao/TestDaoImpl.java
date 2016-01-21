package com.nemsolutions.aurabase.components.generic.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemsolutions.aurabase.components.generic.model.Test;
import com.nemsolutions.auracore.orm.HibernateRepository;


@Repository
public class TestDaoImpl extends HibernateRepository implements TestDao {

	@Autowired
	protected TestDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Test getTestById(Integer id) {
		Criteria criteria = getSession().createCriteria(Test.class);
		criteria.add(Restrictions.eq("id", id));
		return (Test)criteria.uniqueResult();
	}

	@Override
	public void save(Test test) {
		getSession().save(test);
	}
}
