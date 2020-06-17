package com.kurio.cocktail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.kurio.cocktail.R;

public class SplashActivity extends AppCompatActivity {
    MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        motionLayout = findViewById(R.id.motionLayout);
        startAnimation();
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this, HostActivity.class);
            startActivity(i);
            finish();
        }, 2000);
    }

    private void startAnimation(){
        motionLayout.transitionToEnd();
    }
}