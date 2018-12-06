package com.example.elucc.myapplication;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

final class Constants {

    private Constants() {
    }

    private static final String PACKAGE_NAME = "com.example.elucc.myapplication";

    static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";


    private static final long GEOFENCE_EXPIRATION_IN_HOURS = Geofence.NEVER_EXPIRE;


    static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS = Geofence.NEVER_EXPIRE;
            //GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    static final float GEOFENCE_RADIUS_IN_METERS = 1609; // 1 mile, 1.6 km


    static final HashMap<String, LatLng> PARKING_LANDMARKS = new HashMap<>();

    static {
        // C-Science East Parking
        PARKING_LANDMARKS.put("C-Science East", new LatLng(41.1432470, -81.3396320));

        // C-Science West Parking
        PARKING_LANDMARKS.put("C-Science West", new LatLng(41.1434350,-81.3292171));
    }
}