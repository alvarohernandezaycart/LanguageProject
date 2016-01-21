define(function (require) {
	'use strict';

	var angular = require('angular');

	require('translate');
	require('translate-static-loader');
	require('translate-handler-log');
	require('angular-sanitize');
	require('translate-static-loader');
	require('translate-handler-log');
	require('angular-i18n-es');
	require('angular-route');
	require('popup');
	require('ngDialog');
	require('messenger');
	require('angularChart')

	var moduleName = 'first';
	var ngModules = ['pascalprecht.translate', 'ngRoute', 'aura-styleguide.directives.table', 'ngDialog'];
	var module = angular.module(moduleName, ngModules);

	module.directive('selector', require('./SelectorDirective'));
	module.directive('editTestDialog', require('./prueba/editDialog/EditTestDialogDirective'));
	module.directive
	module.config(['$routeProvider', function ($routeProvider){
		console.log("loading routing...");
		$routeProvider
			.when("/translation", {
				templateUrl: "/baseexample/first/translation/list",
				controller: require('baseexample/first/prueba/MenuController')
			})
			.otherwise({
				redirectTo: "/translation"
			});
	}]);
	
	
	module.service('MenuService', require('baseexample/first/prueba/MenuService'));
	module.service('MessageHelper', require('common/MessageHelper'));
	module.service('UtilsHelper', require('./Utils'));

	return moduleName;
});
