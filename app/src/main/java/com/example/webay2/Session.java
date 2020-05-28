package com.example.webay2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.webay2.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Session
{
    private SharedPreferences sharedPreferences;
    private final String USER_IN_SESSION = "userInSession";

    public Session(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUser(User user) {
        Gson gsonPaeser = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String userJsonFormat = gsonPaeser.toJson(user);
        sharedPreferences.edit().putString(USER_IN_SESSION, userJsonFormat).commit();
    }

    public User getUser() {
        Gson gsonPaeser = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        User user = gsonPaeser.fromJson(sharedPreferences.getString(USER_IN_SESSION,""), User.class);
        return user;
    }
}
