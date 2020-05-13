package pl.rynski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static MessagesService messagesService = new MessagesService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText)findViewById(R.id.message);
        String message = messageView.getText().toString();
        messagesService.addMessage(message);
        Intent intent = new Intent(this, ReceviceMessageActivity.class);
        intent.putExtra(ReceviceMessageActivity.EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
