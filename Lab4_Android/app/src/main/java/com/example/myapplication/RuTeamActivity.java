package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        RussianTeam russianTeam = RussianTeam.RUSSIAN_TEAMS[ruTeamId];

        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageResource(russianTeam.getLogoImageId());
        imageView.setContentDescription(russianTeam.getName());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(russianTeam.getName());

        ArrayAdapter<String> playersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                RussianTeam.RUSSIAN_TEAMS[ruTeamId].getPlayers()
        );

        ListView listView = (ListView) findViewById(R.id.ru_players);
        listView.setAdapter(playersAdapter);
    }
}
