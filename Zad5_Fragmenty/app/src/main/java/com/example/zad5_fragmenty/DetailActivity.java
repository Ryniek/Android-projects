package com.example.zad5_fragmenty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_LANGUAGE_ID = "id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        LanguageDetalFragment frag = (LanguageDetalFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int languageId = (int) getIntent().getExtras().get(EXTRA_LANGUAGE_ID);
        frag.setLanguageId(languageId);
    }
}
