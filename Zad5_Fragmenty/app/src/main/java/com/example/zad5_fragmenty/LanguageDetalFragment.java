package com.example.zad5_fragmenty;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LanguageDetalFragment extends Fragment {
    private long languageId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            languageId = savedInstanceState.getLong("languageId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null) {
            languageId = savedInstanceState.getLong("languageId");
        } else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            InnerFragment innerFragment = new InnerFragment();
            ft.replace(R.id.test_container, innerFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        return inflater.inflate(R.layout.fragment_language_detal, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            ProgrammingLanguage programmingLanguage = ProgrammingLanguage.languages[(int) languageId];
            title.setText(programmingLanguage.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(programmingLanguage.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("languageId", languageId);
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }
}
