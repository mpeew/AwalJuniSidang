package com.mpewpazi.android.awaljunisidang;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by mpewpazi on 5/29/16.
 */
public class GalKomSharedPreference {
    private static final String PREF_STATUS_LOGIN="statusLogin";
    private static final String PREF_POSTITION_CLICKED_DRAWER="postionClickedDrawer";


    public static boolean isLoggedIn(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_STATUS_LOGIN,false);
    }

    public static void setLoggedIn(Context context,boolean logged){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_STATUS_LOGIN,logged)
                .apply();
    }

    public static int getPositionClicked(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_POSTITION_CLICKED_DRAWER,0);
    }

    public static void setPositionClicked(Context context,int position){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_POSTITION_CLICKED_DRAWER,position)
                .apply();
    }


}
