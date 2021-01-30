package com.example.sql_final;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    public String place_username = "username";
    public String place_password = "password";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TBNAME + "(username VARCHAR, password VARCHAR" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBNAME);
        onCreate(db);
    }

    public long addUser(String uname, String psw) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", uname);
        cv.put("password", psw);
        long res = db.insert(TBNAME, null, cv);
        db.close();
        return res;
    }

    public void deleteUser(String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TBNAME + " WHERE username='" + uname + "';");
        db.close();
    }

    public void updateUser(String uname, String newpsw) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TBNAME + " SET password='" + newpsw + "' WHERE username='" + uname + "';");
        db.close();
    }

    public int checkUser(String uname, String psw) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TBNAME, new String[]{place_username, place_password}, "username=? AND password=?", new String[]{uname, psw}, null, null, null);
        if (cr.moveToFirst()) {
            db.close();
            cr.close();
            return 1;
        } else {
            db.close();
            cr.close();
            return -1;
        }
    }

    public String displayUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM " + TBNAME + ";", null);
        StringBuilder data = new StringBuilder();
        if (cr.moveToFirst()) {
            do {
                data.append(cr.getString(0)).append(" : ").append(cr.getString(1)).append("\n");
            } while (cr.moveToNext());
        }
        return data.toString();
    }

    public int getStudentCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBNAME, null);
        cursor.close();
        return cursor.getCount();

    }
}
