define(function () {
  'use strict';

  function ETagInterceptor(etagCache) {
    return {
      request: function (config) {
    	var url = config.url;
        if (config.method != 'GET' || !etagCache.contains(url)){
          return config;
        }
        
        var etag = etagCache.get(url).etag;
        config.headers['If-None-Match'] = etag;
        return config;
      },
      response: function (response) {

        var url = response.config.url;

        if (!etagCache.isCacheable(response)){
            return response;
        }
     
        if (200 <= response.status && response.status < 300) {
          return etagCache.cache(response).response;
        }

        if (response.status == 304 && !etagCache.contains(url)) {
          console.error("Warning: Server responded 304 to an ETag'ed request but no content is cached");
          return response;
        }

        return etagCache.get(url).response;
      },
      responseError: function (rejection) {  
    	  if(rejection.status===304 && etagCache.contains(rejection.config.url)){
    		  rejection.data = etagCache.get(rejection.config.url).response.data;
    	  }
          return rejection;
        }
    };
  }

  ETagInterceptor.$inject = ['ETagCache'];

  return ETagInterceptor;
});