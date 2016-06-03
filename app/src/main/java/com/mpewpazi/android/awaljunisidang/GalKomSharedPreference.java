package com.mpewpazi.android.awaljunisidang;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by mpewpazi on 5/29/16.
 */
public class GalKomSharedPreference {
    private static final String PREF_STATUS_LOGIN="statusLogin";
    private static final String PREF_POSTITION_CLICKED_DRAWER="postionClickedDrawer";
    private static final String PREF_USERID="userid";


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

    public static String getUserId(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_USERID,null);
    }

    public static void setUserId(Context context,String userId){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_USERID,userId)
                .apply();
    }


}
