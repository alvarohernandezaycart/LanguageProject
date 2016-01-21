define(function(require) {
	'use strict';

	var angular = require('angular');	
	require('jquery');
	
	var appName = 'aurabase';
	var ngModules = ['pascalprecht.translate', require('aura/auraDirectivesModule'), require('common/commonModule')];

	
	 return function(modules) {
		if (!modules || modules.length === 0) {
			throw new Error("No modules have been defined");
		}

		if (modules.indexOf('first') > -1) {
			ngModules.push(require('baseexample/first/firstModule'));
		}

		if (modules.indexOf('second') > -1) {
			ngModules.push(require('baseexample/second/secondModule'));
		}
		angular.module(appName, ngModules);
		return {
			bootstrap : function(element) {
				angular.bootstrap(element, [ appName ]);
			}
		};
	};
});		  