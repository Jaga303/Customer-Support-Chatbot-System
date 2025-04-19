package com.jaga.customerchatbot;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private TextView chatDisplay;
    private EditText userInput;
    private Button sendBtn;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatDisplay = findViewById(R.id.chatDisplay);
        userInput = findViewById(R.id.userInput);
        sendBtn = findViewById(R.id.sendBtn);
        scrollView = findViewById(R.id.chatScroll);

        chatDisplay.setMovementMethod(new ScrollingMovementMethod());

        showWelcomeMessage();

        sendBtn.setOnClickListener(v -> {
            String input = userInput.getText().toString().trim();
            if (!input.isEmpty()) {
                appendUserMessage(input);
                handleUserInput(input.toLowerCase());
                userInput.setText("");
                scrollToBottom();
            } else {
                Toast.makeText(this, "Please type something!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showWelcomeMessage() {
        chatDisplay.setText("🤖 *ShopEase Assistant*\n\nWelcome! How can I help you today?\n\n" +
                "✨ Try typing:\n" +
                "• 🔐 Login help\n" +
                "• 📝 Signup info\n" +
                "• 🔄 Reset password\n" +
                "• 📦 Track order\n" +
                "• 🔁 Return / Exchange\n" +
                "• 💸 Refund\n" +
                "• 🚪 Logout\n");
    }

    private void handleUserInput(String input) {
        switch (input) {
            case "login":
            case "login help":
                respond("Please enter your registered email and password on the login screen.");
                break;
            case "signup":
            case "signup info":
                respond("To sign up, go to the Signup screen and fill in your details.");
                break;
            case "reset password":
            case "forgot password":
                respond("A reset link will be sent to your registered email.");
                break;
            case "track order":
                respond("Your order is on the way! 🚚 Expected delivery: Tomorrow by 6 PM.");
                break;
            case "return":
                respond("To return an item, go to *My Orders* > *Return* and select the item.");
                break;
            case "refund":
                respond("Refunds are processed within 3–5 business days after return pickup.");
                break;
            case "exchange":
                respond("Exchange requested! Pickup scheduled for tomorrow, replacement on the way.");
                break;
            case "logout":
                respond("You have been successfully logged out. See you again soon!");
                break;
            case "hi":
            case "hello":
                respond("Hi there! 😊 How can I assist you today?");
                break;
            default:
                respond("❗ Sorry, I didn’t get that. Try something like *track order* or *refund*.");
        }
    }

    private void appendUserMessage(String message) {
        chatDisplay.append("\n\n👤 *You*: " + message);
    }

    private void respond(String message) {
        chatDisplay.append("\n🤖 *Bot*: " + message);
    }

    private void scrollToBottom() {
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }

    // Optional feature: add time to messages
    private String getCurrentTime() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }
}
