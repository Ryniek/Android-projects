package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ItTeamActivity extends AppCompatActivity {

    public static final String ITTEAM_ID = "itId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int itTeamId = (Integer)getIntent().getExtras().get(ITTEAM_ID);
        ItalianTeam italianTeam = ItalianTeam.ITALIAN_TEAMS[itTeamId];

        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageResource(italianTeam.getLogoImageId());
        imageView.setContentDescription(italianTeam.getName());

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(italianTeam.getName());

        ArrayAdapter<String> playersAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                ItalianTeam.ITALIAN_TEAMS[itTeamId].getPlayers()
        );

        ListView listView = (ListView) findViewById(R.id.it_players);
        listView.setAdapter(playersAdapter);
    }
}
