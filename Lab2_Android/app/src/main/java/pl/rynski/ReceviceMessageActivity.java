package pl.rynski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReceviceMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recevice_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.messageView);
        textView.setText(messageText);
    }

    public void displayAllMessages(View view) {
        Intent intent = new Intent(this, DisplayMessagesActivity.class);
        startActivity(intent);
    }
}
