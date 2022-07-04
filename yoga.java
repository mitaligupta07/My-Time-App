package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class yoga extends AppCompatActivity {
    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray= new int[]{
                R.id.yo1,R.id.yo2, R.id.yo3, R.id.yo4, R.id.yo5, R.id.yo6,
                R.id.yo7,R.id.yo8, R.id.yo9, R.id.yo10, R.id.yo11, R.id.yo12,
                R.id.yo13, R.id.yo14, R.id.yo15,
        };
    }


    public void ImageButtonClick(View view) {
        for(int i=0;i<newArray.length;i++ ){
            if (view.getId()==newArray[i]){
                int value= i+1;
                Log.i("First", String.valueOf(value));
                Intent intent= new Intent(yoga.this, yoga2.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}