(function (window, require) {
  "use strict";
  var allTestFiles, TEST_REGEXP;

  allTestFiles = [];
  TEST_REGEXP = /Test\.js$/;

  Object.keys(window.__karma__.files).forEach(function (file) {
    if (TEST_REGEXP.test(file)) {
      allTestFiles.push(file);
    }
  });

  require({
    // "/base" is the URL from where karma is serving project files
    baseUrl: '/base/modules/',
    paths: {
      'text': '../bower_components/requirejs-text/text',
      'angular': '../bower_components/angular/angular',
      'angular-route': '../bower_components/angular-route/angular-route',
      'translate': '../bower_components/angular-translate/angular-translate',
      'translate-static-loader': '../bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files',
      'translate-handler-log': '../bower_components/angular-translate-handler-log/angular-translate-handler-log',
      'domready': '../bower_components/requirejs-domready/domReady',
      'Faker': '../bower_components/Faker/Faker',
      'moment': '../bower_components/moment/moment',
      'numeral': '../bower_components/numeral/numeral',
      'bootstrap.position': '../bower_components/angular-ui-bootstrap/src/position/position',
      'bootstrap.datepicker': '../bower_components/angular-ui-bootstrap/src/datepicker/datepicker',
      'bootstrap.bindHtml': '../bower_components/angular-ui-bootstrap/src/bindHtml/bindHtml',
      'bootstrap.typeahead': '../bower_components/angular-ui-bootstrap/src/typeahead/typeahead',
      'sockjs': '../non_bower_components/socksjs/sockjs-0.3.4',
      'stompjs': '../bower_components/stomp-websocket/lib/stomp',
      'depot': '../bower_components/depot/depot',
      'mocks': '../bower_components/angular-mocks/angular-mocks'
    },
    shim: {
      'angular': { exports: 'angular'},
      'angular-route': {deps: ['angular'], exports: 'angular-route'},
      'translate': {deps: ['angular']},
      'translate-static-loader': {deps: ['translate']},
      'translate-handler-log': {deps: ['translate']},
      'bootstrap.position': {deps: ['angular']},
      'bootstrap.bindHtml': {deps: ['angular']},
      'bootstrap.datepicker': {deps: ['angular', 'bootstrap.position']},
      'bootstrap.typeahead': {deps: ['angular', 'bootstrap.position', 'bootstrap.bindHtml']},
      'sockjs': {exports: 'SockJS'},
      'stompjs': {deps: ['sockjs'], exports: 'Stomp'},
      'mocks': {deps: ['angular'], exports: 'angular.mock'}
    }
  }, allTestFiles, function () {
    window.__karma__.start();
  }, function (err) {
    var failedModules = err.requireModules;
    console.log("err", err);

    if (failedModules && failedModules[0]) {
      throw new Error("Module couldn't be loaded: " + failedModules);
    } else {
      throw new Error("Unkown error:" + err);
    }
  });
}(window, require));