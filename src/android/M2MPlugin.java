package com.inmarket.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.inmarket.m2m.M2MBeaconMonitor;

public class M2MPlugin extends CordovaPlugin {
    private static final String SET_USER_ID = "setUserId";
    private static final String SET_OPT_IN_FOR_PUSH = "setOptInForPush";
    private static final String SET_PUSH_TOKEN = "setPushToken";
    private static final String START_SERVICE = "startService";
    private static final String STOP_SERVICE = "stopService";
    private static final String REQUEST_LOCATION_PERMISSION = "requestLocationPermission";
    private static final String CHECK_LOCATION_PERMISSION = "checkLocationPermission";
    private static final String SET_OPT_IN_FOR_GEOFENCING = "setOptInForGeofencing";

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
      if (action.equals(SET_USER_ID)){
        final String userId = args.getString(0);
        M2MBeaconMonitor.setPublisherUserId(userId);

        callbackContext.success();
        return true;
      } else if (action.equals(SET_OPT_IN_FOR_PUSH)){
        final Boolean optIn = args.getBoolean(0);
        M2MBeaconMonitor.setOptInForPush(optIn);
        
        callbackContext.success();
        return true;
      } else if (action.equals(SET_PUSH_TOKEN)){
        final String token = args.getString(0);
        M2MBeaconMonitor.setPushToken(this.cordova.getActivity().getApplicationContext(), token);

        callbackContext.success();
        return true;
      } else if (action.equals(START_SERVICE)){
        M2MBeaconMonitor.startService();

        callbackContext.success();
        return true;
      } else if (action.equals(STOP_SERVICE)){
        M2MBeaconMonitor.stopService(this.cordova.getActivity().getApplicationContext());

        callbackContext.success();
        return true;
      } else if (action.equals(REQUEST_LOCATION_PERMISSION)){
        M2MBeaconMonitor.requestLocationPermission(this.cordova.getActivity());

        callbackContext.success();
        return true;
      } else if (action.equals(CHECK_LOCATION_PERMISSION)){
        final Boolean hasPermission = M2MBeaconMonitor.checkLocationPermission(this.cordova.getActivity());
        
        final JSONObject result = new JSONObject();
        result.put("has_permission", hasPermission);
        callbackContext.success(result);

        return true;
      } else if (action.equals(SET_OPT_IN_FOR_GEOFENCING)){
        final Boolean optIn = args.getBoolean(0);
        M2MBeaconMonitor.setOptInForGeofencing(optIn);

        callbackContext.success();
        return true;
      } else {
        callbackContext.error("Unknown/unsupported action");
      }

      return false;
    }
}