package pl.rynski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FrameLayoutActivity extends AppCompatActivity {
    public int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
    }

    public void onToggleButtonCliicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        ImageView imageView = (ImageView)findViewById(R.id.background_image);
        TextView titleView = (TextView)findViewById(R.id.sport_title);
        TextView descView = (TextView)findViewById(R.id.sport_desc);
        if(on) {
            imageView.setImageResource(R.drawable.pilka_nozna);
            titleView.setText(R.string.football_title);
            descView.setText(R.string.football_description);
        } else {
            imageView.setImageResource(R.drawable.pilka);
            titleView.setText(R.string.volleyball_title);
            descView.setText(R.string.volleyball_description);
        }
    }

    public void checkQuiz(View view) {
        CheckBox checkBox_io = (CheckBox) findViewById(R.id.checkbox_io);
        boolean checked = checkBox_io.isChecked();
        if(checked) {
            counter++;
        }
        CheckBox checkBox_kurek = (CheckBox) findViewById(R.id.checkbox_kurek_monza);
        checked = checkBox_kurek.isChecked();
        if(checked) {
            counter++;
        }
        CheckBox checkBox_ngapeth = (CheckBox) findViewById(R.id.checkbox_nationality_ngapeth);
        checked = checkBox_ngapeth.isChecked();
        if(!checked) {
            counter++;
        }
        showScore(view);
        counter = 0;
    }

    private void showScore(View view) {
        CharSequence score = "Twoj wynik to: " + counter + "/3";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, score, duration);
        toast.show();
    }

    public void goConstraint(View view) {
        Intent intent = new Intent(this, ConstraintLayout.class);
        startActivity(intent);
    }
}
