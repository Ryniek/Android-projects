package com.example.zad5_fragmenty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InnerFragment extends Fragment implements View.OnClickListener {

    private boolean like;
    private RadioGroup radioGroup;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            like = savedInstanceState.getBoolean("like");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_inner, container, false);
        textView = (TextView) layout.findViewById(R.id.answer);
        textView.setText(Boolean.toString(like));

        radioGroup = (RadioGroup) layout.findViewById(R.id.grouup);
        Button confirmButton = (Button)layout.findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("like", like);
    }

    public void checkQuiz(View view) {
        //RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.grouup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);

        String selectedText = (String) radioButton.getText();
        if(selectedText.equals("Tak"))
            like = true;
        if(selectedText.equals("Nie"))
            like = false;
        System.out.println(like);
        //textView = (TextView) view.findViewById(R.id.answer);
        textView.setText(Boolean.toString(like));
        System.out.println(textView.getText());
    }

/*    private void showAnswer(View view) {

        TextView textView = (TextView) view.findViewById(R.id.answer);
        textView.setText(Boolean.toString(like));
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm_button:
                checkQuiz(v);
                break;
        }
    }
}
