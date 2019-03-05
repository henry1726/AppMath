package com.example.henrr.appmath;

//@Override
//Clase para la creación de la base de datos SQLite.
//Contendrá una tabla con atributos: Nombre, apellidos, correo, user, password, nivel, trofeos y exámenes.

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class BDRegistro extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="usuario.db";
    public static final String CREATE_TABLE_USUARIO="create table usuario(ID integer primary key autoincrement, nombre text, apellidos text, " +
            "correo text, user text, password text, nivel text, examenes text)";
    public static final String UPGRADE_TABLE_USUARIO= "DROP TABLE IF EXISTS usuario";

    public BDRegistro(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USUARIO);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newversion)
    {
        db.execSQL(UPGRADE_TABLE_USUARIO);
        onCreate(db);
    }


}
