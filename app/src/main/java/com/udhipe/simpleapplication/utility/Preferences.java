package com.udhipe.simpleapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    static final String KEY_TOKEN = "KEY_TOKEN";
    static final String KEY_ACCOUNT_ID = "KEY_ACCOUNT_ID";

    private static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveAccountToken(Context context, String token) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public static String getAccountToken(Context context) {
        return getPreferences(context).getString(KEY_TOKEN, "");
    }

    public static void saveAccountId(Context context, String id) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(KEY_ACCOUNT_ID, id);
        editor.apply();
    }

    public static String getAccountId(Context context) {
        return getPreferences(context).getString(KEY_ACCOUNT_ID, "");
    }

    public static void clearAccountToken(Context context) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.remove(KEY_TOKEN);
        editor.remove(KEY_ACCOUNT_ID);
        editor.apply();
    }
}
