package com.nemsolutions.aurabase.components.generic;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemsolutions.aurabase.components.generic.dao.Test2Dao;
import com.nemsolutions.aurabase.components.generic.dto.TestDetail2;
import com.nemsolutions.aurabase.components.generic.model.Test2;

@Service
@Transactional
public class TestService {
	
	private Test2Dao testDao;
	
	@Autowired
	public void setCodeDao2(Test2Dao test2Dao) {
		this.testDao = test2Dao;
	}
	
	public List<TestDetail2> getTest(Integer testId){
		Test2 t = testDao.getTestById(testId);
		TestDetail2 td2 = new TestDetail2(t.getId(),t.getName(),t.getSurname(),t.getTlfNumber(),t.getAddress());
		List<TestDetail2> tds = new ArrayList<TestDetail2>();
		tds.add(td2);
		return tds;
	}
	
	public void saveAllTests2(List<Test2> tests){
		for(Test2 test : tests){
			testDao.save(test);
		}
	}
	
	public List<TestDetail2> getAllTests(){
		List<Test2> Tests = testDao.getAllTests();
		List<TestDetail2> tds = new ArrayList<TestDetail2>();
		for (Test2 t : Tests) {
			TestDetail2 td = new TestDetail2(t.getId(),t.getName(),t.getSurname(),t.getTlfNumber(),t.getAddress());
			tds.add(td);
		}
		return tds;
	}
	
	public boolean remove(Integer testId) {
		try {
			//campaignRouteDao.removeByCampaignId(campaignId, clientId); //Uncomment if wanting cascade delete
			testDao.remove(testId);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void saveTest(Integer id, String name, String surname, String tlfNumber,String address) {

		Test2 test = new Test2(id,name,surname,tlfNumber,address);
		testDao.save(test);
	}
	
	public void updateTest(Integer id, String name, String surname, String tlfNumber,String address) {
		Test2 test = new Test2(id,name,surname,tlfNumber,address);
		testDao.update(test);
	}
}