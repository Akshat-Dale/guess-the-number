package com.akshatdale.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splashScreen extends AppCompatActivity {
ImageView logoimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logoimage = findViewById(R.id.logoimage);
        logoimage.setAlpha(0f);
        logoimage.animate().alpha(1).setDuration(2500);

        Intent intent = new Intent(splashScreen.this,MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },4000);
    }
}