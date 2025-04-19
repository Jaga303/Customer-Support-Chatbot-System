package com.jaga.customerchatbot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
Intent i1;
LottieAnimationView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        l1 = findViewById(R.id.lt);
        i1 = new Intent(getApplicationContext(),MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                l1.setAnimation(R.raw.lottie2);
                l1.playAnimation();
                startActivity(i1);
                finish();

            }
        },3000);
    }
}