package com.allaber.iq.utils;

import static com.allaber.iq.utils.Constants.APP_PREFERENCES;
import static com.allaber.iq.utils.Constants.USER_AGE;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;
    private int SHARED_PREFERENCES_MODE = 0;

    public PreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, SHARED_PREFERENCES_MODE);
        spEditor = sharedPreferences.edit();
    }

    public void saveUserAge(int age) {
        spEditor.putInt(USER_AGE, age);
        spEditor.apply();
    }

    public int getUserAge() {
        return sharedPreferences.getInt(USER_AGE, 0);
    }
}
