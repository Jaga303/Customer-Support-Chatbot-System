package com.jaga.customerchatbot; // change this to your actual package name

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class ChatConversationActivity extends AppCompatActivity {

    TextView chatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_conversation);

        chatTextView = findViewById(R.id.chattext);

        // Get the message from the intent
        String message = getIntent().getStringExtra("message");

        // Display the message in the TextView
        if (message != null && !message.isEmpty()) {
            chatTextView.setText(message);
        } else {
            chatTextView.setText("No message received.");
        }
    }
}
