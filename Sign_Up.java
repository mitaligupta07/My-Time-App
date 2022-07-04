package com.example.mytime;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import android.os.Bundle;

public class Sign_Up extends AppCompatActivity {
    ImageButton backbtn;
    Button next;
    TextView titletext;
    TextInputLayout fullName, username, email, password, cfmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        backbtn=(ImageButton) findViewById(R.id.image1);
        next=findViewById(R.id.button3);
        titletext=findViewById(R.id.title_text);
        fullName=findViewById(R.id.full_name);
        email=findViewById(R.id.email);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        cfmpassword=findViewById(R.id.cfmpassword);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Sign_Up.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void callNextSignupScreen(View view) {

        if(!validateFullName() | !validateUserName() |!validateEmail() |!validatePassword() |!validatecfmPassword()){
            return;
        }

        Intent intent = new Intent(getApplicationContext(), SignUp1.class);

        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back");
        pairs[1] = new Pair<View, String>(next, "transition_next");
        pairs[2] = new Pair<View, String>(titletext, "transition_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(Sign_Up.this,pairs);
            startActivity(intent, options.toBundle());
        }
        else{
            startActivity(intent);
        }


    }

    private boolean validateFullName(){
        String val= fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            fullName.setError("Field cannot be empty");
            return false;
        }
        else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateUserName(){
        String val= username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{4,20}\\z";

        if (val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }else if (val.length()>20){
            username.setError("Username is too large!");
            return false;
        }
        else if (!val.matches(checkspaces)){
            username.setError("no white spaces are allowed");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String val= email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches(checkEmail)){
            email.setError("Invalid Email");
            return false;
        }
        else{
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String val= password.getEditText().getText().toString().trim();
        String checkPassword = "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "((?=.*[@#$%^&+=]))"+
                "(?=\\S+$)"+
                ".{4,}"+
                "$";

        if (val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }
        if (!val.matches(checkPassword)){
            password.setError("Password should contain atleast 4 char,special char, number,Capital and small letter");
            return false;
        }


        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatecfmPassword() {
        String val = cfmpassword.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            cfmpassword.setError("Field cannot be empty");
            return false;
        }
        if (!password.equals(cfmpassword)) {
            cfmpassword.setError("Invalid Password");
            return true;
        } else {
            password.setError(null);
            password.setErrorEnabled(true);
            return true;
        }
    }
}