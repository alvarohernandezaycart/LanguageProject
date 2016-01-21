define(function () {
  'use strict';

  function ErrorLogger($http) {
    return {
      log: function (details) {
        $http.post('/logger/error', {
          context: navigator.userAgent,
          details: details
        });
      }
    };
  }

  ErrorLogger.$inject = ['$http'];

  return ErrorLogger;
});