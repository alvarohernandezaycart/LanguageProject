define(function (require) {
	'use strict';

	var angular = require('angular');

	require('translate');
	require('angular-sanitize');
	require('translate-static-loader');
	require('translate-handler-log');
	require('angular-i18n-es');
	require('angular-route');

	var moduleName = 'second';
	var ngModules = ['pascalprecht.translate', 'ngRoute', 'ngSanitize'];
	var module = angular.module(moduleName, ngModules);

	module.config(['$routeProvider', function ($routeProvider){
		console.log("loading second example module");
		$routeProvider
			.when("/summary", {
				templateUrl: "/baseexample/second/summary",
				controller: require('baseexample/second/SecondSummaryController')
			})
			.otherwise({
				redirectTo: "/summary"
			});
	}]);

	return moduleName;
});
