package com.bambazu.fireup.Config;

import android.app.Application;
import com.bambazu.fireup.Model.Place;
import com.bambazu.fireup.R;

import java.util.ArrayList;

/**
 * Created by blackxcorpio on 26/12/2014.
 */
public class Config extends Application {
    public static double currentLatitude = 0.0;
    public static double currentLongitude = 0.0;
    public static final int MIN_TIME = 0;
    public static final int MIN_DISTANCE = 0;
    public static ArrayList<Place> currentPlaces;

    @Override
    public void onCreate() {
        super.onCreate();
        com.parse.Parse.initialize(this, "W8c7QBPJW1B2FBqCFwZPra6fHvIZcQncEl3USxBJ", "roS4gCRfShVZeQ8GDQgcrgOttWQ83tChFuYPLhqh");
    }

    public static int setPlaceColor(String type){
        int color = 0;

        if(type.equals("motel")){
            color = R.color.motel;
        }
        else if(type.equals("sexshop")){
            color = R.color.sexshop;
        }
        else if(type.equals("gaybar")){
            color = R.color.gaybar;
        }
        else if(type.equals("swingerbar")){
            color = R.color.swingerbar;
        }
        else if(type.equals("massagecenter")){
            color = R.color.massagecenter;
        }

        return color;
    }

    public static double getDistance(double sourceLatitude, double sourceLongitude, double destinationLatitude, double destinationLongitude){
        double theta = sourceLongitude - destinationLongitude;
        double dist = Math.sin(deg2rad(sourceLatitude)) * Math.sin(deg2rad(destinationLatitude)) + Math.cos(deg2rad(sourceLatitude)) * Math.cos(deg2rad(destinationLatitude)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return Math.round(dist * 100.0) / 100.0;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}