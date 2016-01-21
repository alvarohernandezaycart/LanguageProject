package com.nemsolutions.aurabase.components.generic.builder;

import com.nemsolutions.auracore.builder.Builder;
import com.nemsolutions.language.app.model.App;

public class AppBuilder extends Builder<App> {
	private String [] apps = {"auraBase","auraWheel","auraMaint","auraDiag", "auraLube"};
	private String [] technology = {"json","json","json","properties","properties"};
	
	public AppBuilder() {
	}

	private AppBuilder(App instance) {
		super(instance);
	}

	public AppBuilder randomFor(Integer i) {
		instance = new App(apps[i],technology[i]);
		return new AppBuilder(instance);
	}


}