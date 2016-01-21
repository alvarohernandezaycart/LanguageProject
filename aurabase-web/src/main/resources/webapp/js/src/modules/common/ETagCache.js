define(function (require) {
  'use strict';

  var depot = require('depot');

  function ETagCache($window) {
    var storage = depot('etag_cache', {idAttribute: 'url', storageAdaptor: $window.sessionStorage});

    function buildEntry(response) {
      return {
        url: response.config.url,
        etag: response.headers('ETag'),
        response: response
      };
    }

    function cache(response) {
      var entry = buildEntry(response);
      if (contains(entry))
        return storage.update(entry);
      return storage.save(entry);
    }

    function contains(url) {
      return !!storage.get(url);
    }

    function get(url) {
      return storage.get(url);
    }

    function isCacheable(response) {
      return response.config.method == 'GET' && response.headers('ETag');
    }

    return {
      cache: cache,
      contains: contains,
      get: get,
      isCacheable: isCacheable
    };
  }

  ETagCache.$inject = ['$window'];

  return ETagCache;
});