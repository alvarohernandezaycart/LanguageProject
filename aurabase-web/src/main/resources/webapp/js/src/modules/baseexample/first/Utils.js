define(function () {
  'use strict';

  function helperTimeToMinutesSeconds(time) {
	if (time == undefined) {
		return "";
	} else {
		var d = Number(time);
		if (time < 60) {
			var seg = Math.floor(d % 3600 % 60);
			return seg + "s";
		} else {
			var min = Math.floor(d / 60);
			var seg = Math.floor(d % 3600 % 60);
			return min + "m"+ " " + seg + "s";
		}
	}
  }
  
  function helperTimeToMinutes(time) {
	if (time == undefined) {
		return "";
	} else {
		var d = Number(time);
			var min = Math.floor(d / 60);
			return min + "m";
	}
  }
  
  function helperTimeToSeconds(time) {
	  if (time == undefined) {
		  return "";
	  } else {
		  return time + "s";
	  }
  }
  
  function timeSecondsToMinutes(time) {
	  if (time == undefined) {
			return undefined;
		} else {
			var d = Number(time);
			var min = Math.floor(d / 60);
			return min;
		} 
  }
  
  function timeMinutesToSeconds(time) {
	  if (time == undefined) {
		  return undefined;
	  } else {
		  return time * 60;
	  }
  }

  return function ($window) {
    return {
    	helperTimeToMinutesSeconds: helperTimeToMinutesSeconds,
    	helperTimeToMinutes: helperTimeToMinutes,
    	helperTimeToSeconds: helperTimeToSeconds,
    	timeSecondsToMinutes: timeSecondsToMinutes,
    	timeMinutesToSeconds: timeMinutesToSeconds
    };
  };
});