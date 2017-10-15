package com.pentavalue.yousry.rakaislamicapp.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yousry on 10/2/2017.
 */

public class Util {
    public static final String SHARED_KEY = "SALATY_PREF";
    public static final String ANIMATION_LOADING = "BallBeatIndicator";

    public static final String MuslimAPI = "ede19e23a1786e52502fd47b43cc664f";
    public static final String CITY_SHARED_PREFERENCE = "city_pref_100";
    public static final String COUNTRY_SHARED_PREFERENCE = "country_pref_100";

    public static final String CITY_EXTRA = "city_extra_100";
    public static final String COUNTRY_EXTRA = "country_extra_100";
    public static final String POSITION_COUNTRY_EXTRA = "position_extra_100";

    public static final String CHECK_LOACTION = "check_pref_100";




    //Checking Network Connection

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected())
        {
            isAvailable = true;

        }
        return isAvailable;
    }


}
