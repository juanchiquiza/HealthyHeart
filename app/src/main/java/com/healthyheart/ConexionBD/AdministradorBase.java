package com.healthyheart.ConexionBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juan on 31/01/2016.
 */
    public class AdministradorBase extends SQLiteOpenHelper {


    public AdministradorBase(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table username(id integer primary key autoincrement, usuario text,contrasena text)");
    }

    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        // db.execSQL("drop table if exists agenda");
        // db.execSQL("create table agenda(dni integer primary key, nombre text, colegio text, nromesa integer)");
        //  db.execSQL("create table agenda(cedula integer primary key, nombre text,telefono integer)");
    }
}



