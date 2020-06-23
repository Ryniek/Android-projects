package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertTeam(SQLiteDatabase db, String name, List<String> players, int resourceId, String league) {
        ContentValues teamValues = new ContentValues();
        teamValues.put("NAME", name);
        teamValues.put("PLAYER_1", players.get(0));
        teamValues.put("PLAYER_2", players.get(1));
        teamValues.put("PLAYER_3", players.get(2));
        teamValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert(league, null, teamValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE IT_TEAM (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "PLAYER_1 TEXT, " +
                    "PLAYER_2 TEXT, " +
                    "PLAYER_3 TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER);");
            insertTeam(db, "Perugia", Arrays.asList("Wilfredo Leon", "Aleksandar Atanasijević", "Filippo Lanza"),
                    R.drawable.perugia, "IT_TEAM");
            insertTeam(db, "Lube Civitanova", Arrays.asList("Osmany Juantorena", "Joandry Leal Hidalgo", "Luciano De Cecco"),
                    R.drawable.lube, "IT_TEAM");
            insertTeam(db, "Modena", Arrays.asList("Micah Christenson", "Matthew Anderson", "Ivan Zaytsev"),
                    R.drawable.modena, "IT_TEAM");

            db.execSQL("CREATE TABLE PL_TEAM (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "PLAYER_1 TEXT, " +
                    "PLAYER_2 TEXT, " +
                    "PLAYER_3 TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER);");
            insertTeam(db, "Zaksa Kędzierzyn Koźle", Arrays.asList("Benjamin Toniutti", "Łukasz Kaczmarek", "Paweł Zatorski"),
                    R.drawable.zaksa, "PL_TEAM");
            insertTeam(db, "PGE Skra Bełchatów", Arrays.asList("Mariusz Wlazły", "Artur Szalpuk", "Milad Ebaidpour"),
                    R.drawable.skra, "PL_TEAM");
            insertTeam(db, "Jastrzębski Węgiel", Arrays.asList("Christian Fromm", "Julian Jyneel", "Lukas Kampa"),
                    R.drawable.jsw, "PL_TEAM");

            db.execSQL("CREATE TABLE RU_TEAM (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "PLAYER_1 TEXT, " +
                    "PLAYER_2 TEXT, " +
                    "PLAYER_3 TEXT, " +
                    "IMAGE_RESOURCE_ID INTEGER);");
            insertTeam(db, "Zenit Kazań", Arrays.asList("Maxim Mikhaylov", "Alexander Butko", "Cwetan Sokolow"),
                    R.drawable.zenit, "RU_TEAM");
            insertTeam(db, "Lokomotiw Nowosybirsk", Arrays.asList("Marko Ivović", "Siergiej Sawin", "Pawieł Krugłow"),
                    R.drawable.lokomotiv, "RU_TEAM");
            insertTeam(db, "Kuzbass Kemerowo", Arrays.asList("Igor Kobzar", "Aleksandr Markin", "Michaił Szczerbakow"),
                    R.drawable.kuzbass, "RU_TEAM");
        }
    }
}
