package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class meditation extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        newArray= new int[]{
                R.id.med1,R.id.med2, R.id.med3, R.id.med4, R.id.med5, R.id.med6,
                R.id.med7,R.id.med8, R.id.med9, R.id.med10, R.id.med11, R.id.med12,
                R.id.med13, R.id.med14, R.id.med15,
        };
    }

    public void ImageButtonClick(View view) {
        for(int i=0;i<newArray.length;i++ ){
            if (view.getId()==newArray[i]){
                int value= i+1;
                Log.i("First", String.valueOf(value));
                Intent intent= new Intent(meditation.this, meditation1.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}