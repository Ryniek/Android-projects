package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupOptionsListView();
        setupFavouritesListView();

    }

    private void setupOptionsListView() {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(MainActivity.this, PolishTeamsActivity.class);
                    startActivity(intent);
                } else if(position == 1) {
                    Intent intent = new Intent(MainActivity.this, ItalianTeamsActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, RussianTeamsActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void setupFavouritesListView() {
        ListView listRuFavourites = findViewById(R.id.list_ru_favourites);
        ListView listPlFavourites = findViewById(R.id.list_pl_favourites);
        ListView listItFavourites = findViewById(R.id.list_it_favourites);
        try {
            SQLiteOpenHelper dbHelper = new DatabaseHelper(this);
            db = dbHelper.getReadableDatabase();
            listPlFavourites.setAdapter(setupFavourites("PL_TEAM"));
            listItFavourites.setAdapter(setupFavourites("IT_TEAM"));
            listRuFavourites.setAdapter(setupFavourites("RU_TEAM"));
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "DB nie jest dostepna", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    private CursorAdapter setupFavourites(String nationality) {
        cursor = db.query(nationality,
                new String[] {"_id", "NAME"},
                "FAVOURITE = 1",
                null, null, null, null);
        CursorAdapter favouriteAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1,
                cursor, new String[]{"NAME"},
                new int[]{android.R.id.text1}, 0);
        return favouriteAdapter;
    }

    public void websiteInfo(View view) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_lab:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Cursor newPlCursor = db.query("PL_TEAM",
                new String[] {"_id", "NAME"},
                "FAVOURITE = 1",
                null, null, null, null);
        Cursor newItCursor = db.query("IT_TEAM",
                new String[] {"_id", "NAME"},
                "FAVOURITE = 1",
                null, null, null, null);
        Cursor newRuCursor = db.query("RU_TEAM",
                new String[] {"_id", "NAME"},
                "FAVOURITE = 1",
                null, null, null, null);
        ListView listPlFavourites = findViewById(R.id.list_pl_favourites);
        ListView listItFavourites = findViewById(R.id.list_it_favourites);
        ListView listRuFavourites = findViewById(R.id.list_ru_favourites);
        CursorAdapter cursorPlAdapter = (CursorAdapter) listPlFavourites.getAdapter();
        cursorPlAdapter.changeCursor(newPlCursor);
        CursorAdapter cursorItAdapter = (CursorAdapter) listItFavourites.getAdapter();
        cursorItAdapter.changeCursor(newItCursor);
        CursorAdapter cursorRuAdapter = (CursorAdapter) listRuFavourites.getAdapter();
        cursorRuAdapter.changeCursor(newRuCursor);
        cursor = newRuCursor;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
