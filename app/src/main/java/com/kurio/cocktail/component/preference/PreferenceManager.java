package com.kurio.cocktail.component.preference;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferenceManager {

    private SharedPreferences sharedPreferences;

    @Inject
    public PreferenceManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getPreferenceString(String key) {
        return sharedPreferences.getString(key, "");
    }


    public int getPreferenceInteger(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public boolean getPreferenceBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void putPreferenceString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void putPreferenceInteger(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public void putPreferenceBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void removePreferenceValue(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public void removeAllPreferences() {
        sharedPreferences.edit().clear().apply();
    }
}
