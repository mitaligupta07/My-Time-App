package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import static android.widget.AdapterView.*;

public class miscellaneous extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous);
        String[] tstory= getResources().getStringArray(R.array.title_story);
        final String[] dstory= getResources().getStringArray(R.array.detail_story);
        listView=findViewById(R.id.list);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, R.layout.row, R.id.rowtext,tstory);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t=dstory[position];
                Intent intent= new Intent(miscellaneous.this, miscellaneous2.class);
                intent.putExtra("story", t);
                startActivity(intent);
            }
        });

    }

    public void goback(View view) {
        Intent intent= new Intent(miscellaneous.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed(){
        Intent intent= new Intent(miscellaneous.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}