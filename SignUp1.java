package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class SignUp1 extends AppCompatActivity {
    ImageButton backbtn;
    Button next;
    TextView titleText;
    RadioGroup radioGrp;
    RadioButton selectedAge;
    DatePicker date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);
        backbtn=findViewById(R.id.image1);
        next=findViewById(R.id.button3);
        titleText=findViewById(R.id.title_text);
        radioGrp=findViewById(R.id.radio_grp);
        date=findViewById(R.id.date);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignUp1.this, Sign_Up.class);
                startActivity(intent);
            }
        });
    }
    public void callNextSignupScreen(View view) {
        if(!validateGender() | !validateAge()){
            return;
        }
        selectedAge= findViewById(radioGrp.getCheckedRadioButtonId());
        String gender= selectedAge.getText().toString();

        int day= date.getDayOfMonth();
        int month= date.getMonth();
        int year= date.getYear();
        String date= day+"/"+month+"/"+year;

        Intent intent = new Intent(getApplicationContext(), SignUp2.class);

        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back");
        pairs[1] = new Pair<View, String>(next, "transition_next");
        pairs[2] = new Pair<View, String>(titleText, "transition_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(SignUp1.this,pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }


    }

    private boolean validateGender(){
        if (radioGrp.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Please select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private boolean validateAge(){
        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        int userAge= date.getYear();
        int isAgeValid= currentYear- userAge;
        if(isAgeValid<13){
            Toast.makeText(this, "you are not eligible:)", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
}