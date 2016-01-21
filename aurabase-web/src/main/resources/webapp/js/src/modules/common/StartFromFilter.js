define(function () {
  'use strict';

  return function () {
    return function (input, start) {
      return input.slice(parseInt(start, 10));
    };
  };
});