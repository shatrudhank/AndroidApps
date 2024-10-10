package com.honeywell.dvm_media_player.common;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
public final class SharedPref {
    public static final String SHARED_VIDEOS_FILE = "VIDEOS_FILE";
    public static final String SHARED_VIDEOS_KEY = "VIDEOS_KEY";

    public void addVideos(Context context, Set<String> videos) {
        SharedPreferences prefs =context.getSharedPreferences(SHARED_VIDEOS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(SHARED_VIDEOS_KEY, videos);
        editor.apply();
    }

    public  Set<String> getVideos(Context context)
    {
        SharedPreferences prefs =context.getSharedPreferences(SHARED_VIDEOS_FILE, Context.MODE_PRIVATE);
        return  prefs.getStringSet(SHARED_VIDEOS_KEY,null);
    }
}
