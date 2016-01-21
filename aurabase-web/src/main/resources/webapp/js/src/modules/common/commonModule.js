define(function (require) {
  'use strict';

  var angular = require('angular'),
      NavBarController = require('common/NavBarController'),
      StartFromFilter = require('common/StartFromFilter'),
      ErrorLogger = require('common/ErrorLogger'),
      EventBus = require('common/EventBus'),
      ETagCache = require('common/ETagCache'),
      ETagInterceptor = require('common/ETagInterceptor'),
      InputDirective = require('common/InputDirective'),
      ViewHelpers = require('common/ViewHelpers'),
      BodyDirective = require('common/BodyDirective');
  
  require('translate');
  require('translate-static-loader');
  require('translate-handler-log');
  require('angular-i18n-es');
  require('jquery');
  

  var moduleName = 'common';
  var ngModules = ['pascalprecht.translate', 'ngLocale'];
  var module = angular.module(moduleName, ngModules);

  module.controller('NavBarController', NavBarController);
  module.filter('startFrom', StartFromFilter);
  module.service('ErrorLogger', ErrorLogger);
  module.service('EventBus', EventBus);
  module.service('ETagCache', ETagCache);
  module.factory('ETagInterceptor', ETagInterceptor);
  module.directive('input', InputDirective);
  module.directive('body', BodyDirective);

  module.config(['$translateProvider', function ($translateProvider) {
    $translateProvider.useStaticFilesLoader({
      prefix: '/translations/locale-',
      suffix: '.json'
    });
    $translateProvider.preferredLanguage('es');
    $translateProvider.useMissingTranslationHandlerLog();
    $translateProvider.useSanitizeValueStrategy(null);
  }]);

  module.config(['$httpProvider', function ($httpProvider) {
    var body = angular.element(document).find('body'),
        csrfHeader = body.attr('csrf-header'),
        csrfToken = body.attr('csrf-token');
    if (!!csrfHeader && !!csrfToken)
      $httpProvider.defaults.headers.common[csrfHeader] = csrfToken;
    $httpProvider.interceptors.push('ETagInterceptor');
  }]);

  module.run(['$window', 'ErrorLogger', function ($window, errorLogger) {
    $window.onerror = function (error, url, lineNumber) {
      errorLogger.log(url + ':' + lineNumber + '\n\n' + error);
    };
  }]);

  module.run(['$rootScope', '$window', function ($rootScope, $window) {
    $rootScope.helpers = ViewHelpers($window);
  }]);


  module.run(['$rootScope', '$location', function ($rootScope, $location) {
    $rootScope.at = function (path) {
      return new RegExp(path).test($location.path());
    };
  }]);
  return  moduleName;
});
