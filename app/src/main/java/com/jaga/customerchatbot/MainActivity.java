package com.jaga.customerchatbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button loginBtn;
    TextView txt;

    String receivedEmail = null;
    String receivedPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        txt = findViewById(R.id.signupLink);

        // Get email and password passed from signup (if available)
        Intent intent = getIntent();
        receivedEmail = intent.getStringExtra("email");
        receivedPassword = intent.getStringExtra("password");

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to signup screen
                Intent signupIntent = new Intent(MainActivity.this, signup.class);
                startActivity(signupIntent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                if (enteredEmail.equals(receivedEmail) &&
                        enteredPassword.equals(receivedPassword)) {

                    Intent chatIntent = new Intent(MainActivity.this, ChatActivity.class);
                    startActivity(chatIntent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
