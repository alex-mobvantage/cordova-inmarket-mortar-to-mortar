package com.inmarket.cordova;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.inmarket.m2m.M2MBeaconMonitor;

public class M2MPlugin extends CordovaPlugin {
    private static final String TAG = "M2M";

    private static final String SET_USER_ID = "setUserId";
    private static final String SET_OPT_IN_FOR_PUSH = "setOptInForPush";
    private static final String SET_PUSH_TOKEN = "setPushToken";
    private static final String START_SERVICE = "startService";
    private static final String STOP_SERVICE = "stopService";
    private static final String GET_IS_SERVICE_STARTED = "getIsServiceStarted";
    private static final String REQUEST_LOCATION_PERMISSION = "requestLocationPermission";
    private static final String CHECK_LOCATION_PERMISSION = "checkLocationPermission";
    private static final String SET_OPT_IN_FOR_GEOFENCING = "setOptInForGeofencing";

    private boolean isStarted = false;

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
      if (action.equals(SET_USER_ID)){
        final String userId = args.getString(0);
        M2MBeaconMonitor.setPublisherUserId(userId);

        Log.d(TAG, "Set user id: " + userId);
        callbackContext.success();
        return true;
      } else if (action.equals(SET_OPT_IN_FOR_PUSH)){
        final Boolean optIn = args.getBoolean(0);
        M2MBeaconMonitor.setOptInForPush(optIn);

        Log.d(TAG, "Set opt in for push: " + optIn);
        callbackContext.success();
        return true;
      } else if (action.equals(SET_PUSH_TOKEN)){
        final String token = args.getString(0);
        M2MBeaconMonitor.setPushToken(this.cordova.getActivity().getApplicationContext(), token);

        Log.d(TAG, "Set push token: " + token);
        callbackContext.success();
        return true;
      } else if (action.equals(START_SERVICE)){
        M2MBeaconMonitor.startService();
        this.isStarted = true;

        Log.d(TAG, "Started service");
        callbackContext.success();
        return true;
      } else if (action.equals(STOP_SERVICE)){
        M2MBeaconMonitor.stopService(this.cordova.getActivity().getApplicationContext());
        this.isStarted = false;

        Log.d(TAG, "Stopped service");
        callbackContext.success();
        return true;
      } else if (action.equals(GET_IS_SERVICE_STARTED)){
        final JSONObject result = new JSONObject();
        result.put("is_started", this.isStarted);

        Log.d(TAG, "Get is started: " + this.isStarted);
        callbackContext.success(result);
        return true;
      } else if (action.equals(REQUEST_LOCATION_PERMISSION)){
        M2MBeaconMonitor.requestLocationPermission(this.cordova.getActivity());

        Log.d(TAG, "Requested location permission");
        callbackContext.success();
        return true;
      } else if (action.equals(CHECK_LOCATION_PERMISSION)){
        final Boolean hasPermission = M2MBeaconMonitor.checkLocationPermission(this.cordova.getActivity());
        
        final JSONObject result = new JSONObject();
        result.put("has_permission", hasPermission);

        Log.d(TAG, "Checked location permission: " + hasPermission);
        callbackContext.success(result);

        return true;
      } else if (action.equals(SET_OPT_IN_FOR_GEOFENCING)){
        final Boolean optIn = args.getBoolean(0);
        M2MBeaconMonitor.setOptInForGeofencing(optIn);

        Log.d(TAG, "Set opt in for geofencing: " + optIn);
        callbackContext.success();
        return true;
      } else {
        Log.e(TAG, "Unknown/unsupported action: " + action);
        callbackContext.error("Unknown/unsupported action");
      }

      return false;
    }
}