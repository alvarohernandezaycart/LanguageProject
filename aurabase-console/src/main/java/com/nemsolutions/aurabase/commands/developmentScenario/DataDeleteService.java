package com.nemsolutions.aurabase.commands.developmentScenario;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nemsolutions.auracore.orm.HibernateRepository;


@Repository
class DataDeleteService extends HibernateRepository {

	private static final Logger logger = LoggerFactory.getLogger(DataDeleteService.class);
		
	@Autowired
	protected DataDeleteService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public void deleteData() {
		deleteStructure();
	}	
	
	/* STRUCTURE ***************************************************************/
	private void deleteStructure() {
		logger.info("######################### Clearing Structure:");
		deleteEntityByDevelopmentClient("Test");
		deleteEntityByDevelopmentClient("App");
//		System.out.println("ENTRO!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		deleteEntityByDevelopmentClient("Language");
//		deleteEntityByDevelopmentClient("Translation");
	}

	private void deleteEntityByDevelopmentClient(String entity) {
		String hql= "DELETE FROM " + entity;
		Query deleteSQL = getSession().createQuery(hql);
		int deletedEntities = deleteSQL.executeUpdate();
		logger.info(String.format("##### %s: %d deleted.",entity,deletedEntities));		
	}

}
