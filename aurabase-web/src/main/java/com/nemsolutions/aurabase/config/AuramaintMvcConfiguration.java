package com.nemsolutions.aurabase.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.nemsolutions.auracore.config.MvcConfiguration;

public class AuramaintMvcConfiguration extends MvcConfiguration {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		addAuramaintInterceptors(registry);
	}

	private void addAuramaintInterceptors(InterceptorRegistry registry){
	}


}
