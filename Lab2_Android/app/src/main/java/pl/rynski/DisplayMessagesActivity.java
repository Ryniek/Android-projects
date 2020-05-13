package pl.rynski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_messages);
        TextView messages = (TextView)findViewById(R.id.messagesDisplay);
        StringBuilder sb = new StringBuilder();
        List<String> allMessages = MainActivity.messagesService.getMessages();
        sb.append("Wszystkie wiadomości: ").append('\n');
        for(String message : allMessages) {
            sb.append(message).append('\n');
        }
        messages.setText(sb);
    }
}
