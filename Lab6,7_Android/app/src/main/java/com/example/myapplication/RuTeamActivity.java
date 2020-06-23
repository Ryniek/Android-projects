package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RuTeamActivity extends AppCompatActivity {

    public static final String RUTEAM_ID = "ruId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int ruTeamId = (Integer)getIntent().getExtras().get(RUTEAM_ID);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("RU_TEAM", new String[] {"NAME", "PLAYER_1", "PLAYER_2", "PLAYER_3", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(ruTeamId)},
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

                TextView textName = (TextView) findViewById(R.id.name);
                textName.setText(name);

                ImageView imageView = (ImageView) findViewById(R.id.photo);
                imageView.setImageResource(photoId);

                ArrayAdapter<String> playersAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        list
                );

                ListView listView = (ListView) findViewById(R.id.ru_players);
                listView.setAdapter(playersAdapter);

                imageView.setContentDescription(name);
            }
            cursor.close();
            db.close();
        }
        catch (Exception e) {
            Toast toast = Toast.makeText(this, "DB nie dziala", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
