# cordova-inmarket-mortar-to-mortar

This is a plugin for accessing the InMarket Mortar to Mortar SDK functionality from within your cordova application.

**_Note: Only Android is currently implemented. Feel free to send a pull request to implement the iOS functionality_**

# Integration

Check out the <a href="http://docs.inmarket.com/">documentation</a> for installing the SDK.

You can skip section 1 of the installation when using this plugin. See section 2 for starting/stopping the service - but note that some of this functionality is exposed through the cordova plugin so you can request location permission and start/stop the service in a contextual way from within the application.

# Cordova Usage

* To add plugin
```
cordova plugin add https://github.com/alex-mobvantage/cordova-inmarket-mortar-to-mortar.git
```

* To remove plugin
```
cordova plugin remove M2M
```

# Supported Methods

* `setUserId(userId, successCallback, errorCallback)`

* `setOptInForPush(optIn, successCallback, errorCallback)`

* `setPushToken(token, successCallback, errorCallback)`

* `startService(successCallback, errorCallback)`

* `stopService(successCallback, errorCallback)`

* `getIsStarted(successCallback, errorCallback)`

Returns an object with boolean property `is_started`

* `requestLocationPermission(successCallback, errorCallback)`

* `checkLocationPermission(successCallback, errorCallback)`

Returns an object with boolean property `has_permission`

* `setOptInForGeofencing(optIn, successCallback, errorCallback)`