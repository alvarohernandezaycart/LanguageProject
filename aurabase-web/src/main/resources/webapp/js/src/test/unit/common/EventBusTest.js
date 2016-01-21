define(['angular','common/EventBus','mocks'], function (angular,EventBus) {
  'use strict';

  describe("The event bus", function () {    

	  it("lets you subscribe and trigger events", inject(function ($rootScope) {
		  var callbackIsCalled = false;	  
		  var eventBus = EventBus($rootScope);		  
		  eventBus.on("event",function callback(){
			  callbackIsCalled = true;
		  });
		  
		  
		  eventBus.broadcast("event",[]);
		  
		  expect(callbackIsCalled).toBe(true); 
	  }));
  });
});