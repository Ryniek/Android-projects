package pl.rynski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void appendTwoDigits(View view) {
        Spinner firstNumber = (Spinner)findViewById(R.id.first_number);
        int first = Integer.parseInt(String.valueOf(firstNumber.getSelectedItem()));
        Spinner secondNumber = (Spinner)findViewById(R.id.second_number);
        int second = Integer.parseInt(String.valueOf(secondNumber.getSelectedItem()));
        int result = first + second;
        TextView textView = (TextView)findViewById(R.id.result);
        textView.setText(String.valueOf(result));
    }

    public void subtractTwoDigits(View view) {
        Spinner firstNumber = (Spinner)findViewById(R.id.first_number);
        int first = Integer.parseInt(String.valueOf(firstNumber.getSelectedItem()));
        Spinner secondNumber = (Spinner)findViewById(R.id.second_number);
        int second = Integer.parseInt(String.valueOf(secondNumber.getSelectedItem()));
        int result = first - second;
        TextView textView = (TextView)findViewById(R.id.result);
        textView.setText(String.valueOf(result));
    }

    public void multiplyTwoDigits(View view) {
        Spinner firstNumber = (Spinner)findViewById(R.id.first_number);
        int first = Integer.parseInt(String.valueOf(firstNumber.getSelectedItem()));
        Spinner secondNumber = (Spinner)findViewById(R.id.second_number);
        int second = Integer.parseInt(String.valueOf(secondNumber.getSelectedItem()));
        int result = first * second;
        TextView textView = (TextView)findViewById(R.id.result);
        textView.setText(String.valueOf(result));
    }

    public void divideTwoDigits(View view) {
        Spinner firstNumber = (Spinner)findViewById(R.id.first_number);
        double first = Double.parseDouble(String.valueOf(firstNumber.getSelectedItem()));
        Spinner secondNumber = (Spinner)findViewById(R.id.second_number);
        double second = Double.parseDouble(String.valueOf(secondNumber.getSelectedItem()));
        if(second == 0) {
            String text = "Nie można dzielić przez 0";
            TextView textView = (TextView)findViewById(R.id.result);
            textView.setText(text);
        }
        else {
            double result = first / second;
            TextView textView = (TextView)findViewById(R.id.result);
            textView.setText(String.valueOf(result));
        }
    }
}
