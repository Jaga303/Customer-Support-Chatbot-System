package com.jaga.customerchatbot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    EditText email, password, name, phone, confirmPassword;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerBtn);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        confirmPassword = findViewById(R.id.confirmPassword);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String password1 = password.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String name1 = name.getText().toString().trim();
                String confirmPassword1 = confirmPassword.getText().toString().trim();

                if (!email1.isEmpty() && !password1.isEmpty() && !name1.isEmpty() && !phone1.isEmpty() && !confirmPassword1.isEmpty()) {
                    if (password1.equals(confirmPassword1)) {
                        // Save credentials
                        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("email", email1);
                        editor.putString("password", password1);
                        editor.apply();

                        Toast.makeText(signup.this, "Signup successful! Please log in.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signup.this, Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(signup.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(signup.this, "Fill in all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
