package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import static com.example.pc.custadvisroyapp.Constants.*;


public class SessionUtil {

    public static Boolean sessionChecked = false;
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    public static int getSessionId(final Activity activity) {
        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        return pref.getInt(SESSION_ID,0);
    }
    public static String getSessionToken(final Activity activity) {
        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        return pref.getString(SESSION_TOKEN,"none");
    }

    public static String getSessionName(final Activity activity) {
        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        return pref.getString(SESSION_NAME,"none");
    }

    public static void setSession(final Activity activity, String name, String token, int id) {
        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        editor = pref.edit();
        editor.putInt(SESSION_ID, id);
        editor.putString(SESSION_TOKEN, token);
        editor.putString(SESSION_NAME, name);
        editor.commit();
    }


    public static void setSingout(final Activity activity){

        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        editor = pref.edit();
        editor.remove (SESSION_TOKEN);
        editor.remove (SESSION_NAME);
        editor.remove (SESSION_EXPIRE);
        editor.commit();
    }

    public static boolean isLoggedIn(final Activity activity){
        pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
        String sessionToken = pref.getString(SESSION_TOKEN,"empty");
        Log.i(Constants.TAG, "Session UTIL isLoggedIn: "+sessionToken);
        if(sessionToken=="empty"){
            return false;
        }
        return true;

    }

}
