package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class yoga2 extends AppCompatActivity {
    String buttonvalue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean mTimeRunning;
    private long mTimemillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga2);
        Intent intent= getIntent();
        buttonvalue=intent.getStringExtra("value");
        int intvalue= Integer.valueOf(buttonvalue);
        switch (intvalue){
            case 1:
                setContentView(R.layout.activity_yo1);
                break;

            case 2:
                setContentView(R.layout.activity_yo2);
                break;

            case 3:
                setContentView(R.layout.activity_yo3);
                break;

            case 4:
                setContentView(R.layout.activity_yo4);
                break;

            case 5:
                setContentView(R.layout.activity_yo5);
                break;

            case 6:
                setContentView(R.layout.activity_yo6);
                break;

            case 7:
                setContentView(R.layout.activity_yo7);
                break;

            case 8:
                setContentView(R.layout.activity_yo8);
                break;

            case 9:
                setContentView(R.layout.activity_yo9);
                break;

            case 10:
                setContentView(R.layout.activity_yo10);
                break;

            case 11:
                setContentView(R.layout.activity_yo11);
                break;

            case 12:
                setContentView(R.layout.activity_yo12);
                break;

            case 13:
                setContentView(R.layout.activity_yo13);
                break;

            case 14:
                setContentView(R.layout.activity_yo14);
                break;

            case 15:
                setContentView(R.layout.activity_yo15);
                break;
        }
        startbtn=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.timer);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimeRunning){
                    stoptimer();

                }
                else{
                    startTimer();

                }
            }
        });
    }
    private void stoptimer(){
        countDownTimer.cancel();
        mTimeRunning=false;
        startbtn.setText("START");
    }
    private void startTimer(){
        final CharSequence value1= mtextview.getText();
        String num1= value1.toString();
        String num2= num1.substring(0,2);
        String num3= num1.substring(3,5);
        final int number= Integer.valueOf(num2)*60 + Integer.valueOf(num3);
        mTimemillis= number*1000;
        countDownTimer= new CountDownTimer(mTimemillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimemillis= millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue= Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent= new Intent(yoga2.this, yoga2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }
                else{
                    newvalue=1;
                    Intent intent= new Intent(yoga2.this, yoga2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        startbtn.setText("Pause");
        mTimeRunning=true;
    }
    private void updateTimer(){
        int minutes= (int)mTimemillis/60000;
        int seconds= (int)mTimemillis%60000/1000;
        String timeoftext="";
        if(minutes<10)
            timeoftext="0";
        timeoftext=timeoftext+minutes+":";
        if(seconds<10)
            timeoftext+="0";
        timeoftext+=seconds;
        mtextview.setText(timeoftext);

    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

}
