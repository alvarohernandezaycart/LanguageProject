package com.nemsolutions.language.app;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemsolutions.language.app.dao.AppDao;
import com.nemsolutions.language.app.dto.AppDetail;
import com.nemsolutions.language.app.model.App;

@Service
@Transactional
public class AppService {
	
	private AppDao appDao;
	
	@Autowired
	public void setAppDao(AppDao AppDao) {
		this.appDao = AppDao;
	}
	
	public AppDetail getApp(Integer AppId){
		App a = appDao.getAppById(AppId);
		AppDetail ad = new AppDetail(a.getApp_id(),a.getName(),a.getTechnology());
		return ad;
	}
	
	public void saveAllApps(List<App> apps){
		for(App App : apps){
			appDao.save(App);
		}
	}
	
	public List<AppDetail> getAllApps(){
		List<App> Apps = appDao.getAllApps();
		List<AppDetail> ads = new ArrayList<AppDetail>();
		for (App a : Apps) {
			AppDetail ad = new AppDetail(a.getApp_id(),a.getName(),a.getTechnology());
			ads.add(ad);
		}
		return ads;
	}
	
	public boolean remove(Integer AppId) {
		try {//Acordarse de on delete cascade

			appDao.remove(AppId);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void saveApp(String name, String technology) {

		App App = new App(name, technology);
		appDao.save(App);
	}
	
	public void updateApp(String name, String technology) {
		App App = new App(name, technology);
		appDao.update(App);
	}
}