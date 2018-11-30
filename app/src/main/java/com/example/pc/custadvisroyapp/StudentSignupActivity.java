package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentSignupActivity extends AppCompatActivity {

    EditText regno, email, password, repassword;
    Button signup;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);

        signup=findViewById(R.id.buttonStudentSignup);

        login=findViewById(R.id.btnLogin);

        password = findViewById(R.id.Password);
        regno = findViewById(R.id.RegNo);
        repassword=findViewById(R.id.RePassword);
        email=findViewById(R.id.email);


        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(regno.getText().toString().isEmpty() || password.getText().toString().isEmpty()|| repassword.getText().toString().isEmpty()|| email.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else if(repassword.getText().toString().matches(password.getText().toString()))
                {
                    signupStudent();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Password not matched",Toast.LENGTH_LONG).show();

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentSignupActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void signupStudent() {
        String RegNo = regno.getText().toString();
        String Password = password.getText().toString();
        String Email= email.getText().toString();

        String method = "signup_student";
        BackgroundUserManagement userManagement = new BackgroundUserManagement(this);
        userManagement.execute(method,RegNo,Password,Email);
    }


}
