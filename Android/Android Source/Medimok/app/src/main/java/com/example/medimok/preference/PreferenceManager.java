package com.example.medimok.preference;
import android.content.Context;
import android.content.SharedPreferences;
import org.jetbrains.annotations.NotNull;

public class PreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String prefer="Shared Preference";
    private String defaultValue="";
    public PreferenceManager(Context context){
        sharedPreferences=context.getSharedPreferences(prefer,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void setData(@NotNull String name, @NotNull String value){
        editor.putString(name,value);
        editor.commit();
    }
    public String getData(String name){
        return sharedPreferences.getString(name,defaultValue);
    }
    public void clearPreference(){
        if(editor!=null){
            editor.clear();
            editor.commit();
        }
    }
}
