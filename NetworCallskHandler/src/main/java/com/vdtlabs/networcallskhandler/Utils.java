package com.vdtlabs.networcallskhandler;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Vinod Dirishala on 08-06-2019
 **/
public class Utils {


    public static boolean isNetworkAvailable(Context context) {
        boolean networkavailable=false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (connectivityManager != null && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                networkavailable = true;
            } else {
                networkavailable = false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return networkavailable;
    }
}