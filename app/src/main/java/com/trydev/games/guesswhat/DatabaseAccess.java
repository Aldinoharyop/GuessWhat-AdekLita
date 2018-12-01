package com.trydev.games.guesswhat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    //Private Constructor to avoid object creation from outside classes

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return a singleton instance of Database Access
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //Open Database Connection
    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if(database != null){
            this.database.close();
        }
    }

    public String[] getTitleBalita(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita WHERE Jenis='1' ORDER BY `ID` ASC", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();

        String[] mStringArray = new String[list.size()];
        mStringArray =list.toArray(mStringArray);

        for(int i = 0; i < mStringArray.length ; i++){
            Log.d("",(String)mStringArray[i]);
        }
        return mStringArray;
    }

    public String[] getDescBalita(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita WHERE Jenis='1' ORDER BY `ID` ASC", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();

        String[] mStringArray = new String[list.size()];
        mStringArray =list.toArray(mStringArray);

        for(int i = 0; i < mStringArray.length ; i++){
            Log.d("",(String)mStringArray[i]);
        }
        return mStringArray;
    }

    public String[] getTitleOrtu(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita WHERE Jenis='2' ORDER BY `ID` ASC", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();

        String[] mStringArray = new String[list.size()];
        mStringArray =list.toArray(mStringArray);

        for(int i = 0; i < mStringArray.length ; i++){
            Log.d("",(String)mStringArray[i]);
        }
        return mStringArray;
    }

    public String[] getDescOrtu(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita WHERE Jenis='2' ORDER BY `ID` ASC", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();

        String[] mStringArray = new String[list.size()];
        mStringArray =list.toArray(mStringArray);

        for(int i = 0; i < mStringArray.length ; i++){
            Log.d("",(String)mStringArray[i]);
        }
        return mStringArray;
    }

    public List<String> getKamusJawa(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getKamusIndonesia(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ArticleAdeklita WHERE Indonesia!='' ORDER BY Indonesia ASC", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getSearchJawa(String keyword){
        List<String> list = new ArrayList<>();
        String queryString = "SELECT * FROM ArticleAdeklita WHERE Ngoko LIKE '" + keyword +"%' ORDER BY Ngoko ASC";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1)+" (Ng) /"+cursor.getString(2)+" (Kr) / "+cursor.getString(3)+" (Ki)");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getSearchIndonesia(String keyword){
        List<String> list = new ArrayList<>();
        String queryString = "SELECT * FROM ArticleAdeklita WHERE Indonesia LIKE '" + keyword +"%' ORDER BY Indonesia ASC";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getSelectedJawa(String kataJawa){
        String queryString = "SELECT * FROM ArticleAdeklita WHERE Ngoko='"+ kataJawa +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        String arti = cursor.getString(4);
        cursor.close();
        return arti;
    }

    public String getSelectedIndonesia(String kataIndonesia){
        String queryString = "SELECT * FROM ArticleAdeklita WHERE Indonesia='"+ kataIndonesia +"'";
        Cursor cursor = database.rawQuery(queryString, null);
        cursor.moveToFirst();
        String arti = cursor.getString(1) +" (Ng)/"+cursor.getString(2)+" (Kr)/"+cursor.getString(3)+" (Ki)";
        cursor.close();
        return arti;
    }

}
