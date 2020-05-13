package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        PolishTeam polishTeam = PolishTeam.POLISH_TEAMS[plTeamId];

        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageResource(polishTeam.getLogoImageId());
        imageView.setContentDescription(polishTeam.getName());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(polishTeam.getName());

        ArrayAdapter<String> playersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                PolishTeam.POLISH_TEAMS[plTeamId].getPlayers()
        );

        ListView listView = (ListView) findViewById(R.id.pl_players);
        listView.setAdapter(playersAdapter);

    }
}
