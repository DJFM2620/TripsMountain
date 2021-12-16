package com.example.exercise_01.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.exercise_01.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MountainEntry {

    private static final String TAG = MountainEntry.class.getSimpleName();

    public final String name;
    public final Uri dynamicUrl;
    public final String url;
    public final String location;

    public MountainEntry(String name, String dynamicUrl, String url, String location){

        this.name = name;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.location = location;
    }

    public static List<MountainEntry> initMountainEntryList(Resources resources){

        InputStream inputStream = resources.openRawResource(R.raw.mountain);

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;

            while((pointer = reader.read(buffer)) != -1){

                writer.write(buffer, 0, pointer);
            }
        }catch (IOException exception){

            Log.e(TAG, "Error al escribir o leer el archivo JSON", exception);
        }finally {

            try {
                inputStream.close();

            }catch (IOException exception){

                Log.e(TAG, "Error al cerrar la conexion con el archivo", exception);
            }
        }

        String jsonMountainString = writer.toString();
        Gson gson = new Gson();

        Type mountaingListType = new  TypeToken<ArrayList<MountainEntry>>(){
        }.getType();

        return gson.fromJson(jsonMountainString, mountaingListType);
    }
}
