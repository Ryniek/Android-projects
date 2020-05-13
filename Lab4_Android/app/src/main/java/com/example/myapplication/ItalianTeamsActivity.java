package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItalianTeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_teams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<ItalianTeam> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                ItalianTeam.ITALIAN_TEAMS
        );
        ListView listView = (ListView) findViewById(R.id.list_italian);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ItalianTeamsActivity.this, ItTeamActivity.class);
                intent.putExtra(ItTeamActivity.ITTEAM_ID, (int) id);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}
