package com.nemsolutions.language.app.dao;

import java.util.List;

import com.nemsolutions.language.app.model.App;


public interface AppDao{
	App getAppById(Integer id);
	void save(App app);
	List<App> getAllApps();
	void remove(Integer appId);
	void update(App app);
}