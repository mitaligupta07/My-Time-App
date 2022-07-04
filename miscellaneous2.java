package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class miscellaneous2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous2);
        textView=findViewById(R.id.txt);
        String dstory= getIntent().getStringExtra("story");
        textView.setText(dstory);
    }
}