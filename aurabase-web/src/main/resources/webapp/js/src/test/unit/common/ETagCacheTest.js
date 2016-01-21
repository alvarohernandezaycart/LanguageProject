define(['common/ETagCache'], function (ETagCache) {
  'use strict';
  
  
  function FakeStorage(){
	  var allItems={};
	  
	  return {
		  clear:function(){
			  allItems={};
		  },
		  getItem:function(key){
			  return allItems[key];
		  },
		  setItem:function(key,item){
			  allItems[key]=item;
		  }
	  };
  }
  
  

  describe("The eTag cache", function () { 
	  function createResponse(url,method,eTagValue){	
		  return {
			  config:{url:url,
				  	  method:method},
			  headers:function(name){
				  if (name ==  'ETag') return eTagValue;
			  }
		  };
	  }
	  
	  var eTagCache;
	  
	  beforeEach(function(){
		  var window = {sessionStorage:FakeStorage()};
		  eTagCache = ETagCache(window); 
	  });

	  it("stores responses and let you obtain stored responses", function (){
		  var url = "url1";
		  eTagCache.cache(createResponse(url,"GET","ETagValue"));
		  expect(eTagCache.contains(url)).toBeTruthy(); 
	  });
	  
	  describe("allows to cache responses", function () {  
		  
		  it("when request method is GET and response header eTag is present", function (){
			  expect(eTagCache.isCacheable(createResponse("","GET","ETagValue"))).toBeTruthy(); 
		  });
		  
		  it("does not cache if method is not GET", function (){
			  expect(eTagCache.isCacheable(createResponse("","PUT","ETagValue"))).toBeFalsy(); 
		  });
		  
		  it("does not cache if response has not eTag", function (){
			  expect(eTagCache.isCacheable(createResponse("","GET"))).toBeFalsy(); 
		  });
	  });
  });
});