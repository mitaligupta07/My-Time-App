package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN= 2000;
    Animation topAnim, bottomAnim;
    TextView textView, textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        textView= findViewById(R.id.textView);
        textView4=findViewById(R.id.textView4);

        textView.setAnimation(topAnim);
        textView4.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(splashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);
    }
}