var exec = require('cordova/exec');

var M2M = {
  setUserId: function(userId, successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'setUserId', [userId]);
  },

  setOptInForPush: function(optIn, successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'setOptInForPush', [optIn]);
  },

  setPushToken: function(token, successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'setPushToken', [token]);
  },

  startService: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'startService');
  },

  stopService: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'stopService');
  },

  requestLocationPermission: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'requestLocationPermission');
  },

  checkLocationPermission: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'checkLocationPermission');
  },

  setOptInForGeofencing: function(optIn, successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'M2M', 'setOptInForGeofencing', [optIn]);
  }
} 

module.exports = M2M;
