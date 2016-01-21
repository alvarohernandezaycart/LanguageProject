define(function () {
  'use strict';

  function EventBus($rootScope) {
    var scope = $rootScope.$new();
    return {
      on: function (event, callback) {
        console.log("Someone wants to be notified whenever", event, "happens");
        scope.$on(event, callback);
      },
      broadcast: function (event, args) {
        console.log("Someone is sending", args, "to", event);
        scope.$broadcast(event, args);
      }
    };
  }

  EventBus.$inject = ['$rootScope'];

  return EventBus;
});