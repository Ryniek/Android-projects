package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlTeamActivity extends AppCompatActivity {

    public static final String PLTEAM_ID = "plId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pl_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int plTeamId = (Integer)getIntent().getExtras().get(PLTEAM_ID);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("PL_TEAM", new String[] {"NAME", "PLAYER_1", "PLAYER_2", "PLAYER_3", "IMAGE_RESOURCE_ID", "FAVOURITE"},
                    "_id = ?",
                    new String[] {Integer.toString(plTeamId)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(0);
                String player1 = cursor.getString(1);
                String player2 = cursor.getString(2);
                String player3 = cursor.getString(3);
                ArrayList list = new ArrayList();
                list.add(player1);
                list.add(player2);
                list.add(player3);
                System.out.println(list);

                int photoId = cursor.getInt(4);
                boolean isFavourite = (cursor.getInt(5) == 1);

                TextView textName = (TextView) findViewById(R.id.name);
                textName.setText(name);

                ImageView imageView = (ImageView) findViewById(R.id.photo);
                imageView.setImageResource(photoId);

                ArrayAdapter<String> playersAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        list
                );

                ListView listView = (ListView) findViewById(R.id.pl_players);
                listView.setAdapter(playersAdapter);

                imageView.setContentDescription(name);

                CheckBox favourite = (CheckBox) findViewById(R.id.pl_favourite);
                favourite.setChecked(isFavourite);
            }
            cursor.close();
            db.close();
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, "DB nie dziala", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void onFavouriteClicked(View view) {
        int plTeamId = (Integer)getIntent().getExtras().get(PLTEAM_ID);

        CheckBox favourite = (CheckBox) findViewById(R.id.pl_favourite);
        ContentValues plValues = new ContentValues();
        plValues.put("FAVOURITE", favourite.isChecked());

        SQLiteOpenHelper openHelper = new DatabaseHelper(PlTeamActivity.this);
        try {
            SQLiteDatabase db = openHelper.getWritableDatabase();
            db.update("PL_TEAM",
                    plValues,
                    "_id = ?",
                    new String[] {Integer.toString(plTeamId)});
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Db nie dziala", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
