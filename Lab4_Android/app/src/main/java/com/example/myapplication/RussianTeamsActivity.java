package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RussianTeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_teams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<RussianTeam> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                RussianTeam.RUSSIAN_TEAMS
        );
        ListView listView = (ListView) findViewById(R.id.list_russian);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RussianTeamsActivity.this, RuTeamActivity.class);
                intent.putExtra(RuTeamActivity.RUTEAM_ID, (int) id);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}
