package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLoginActivity extends AppCompatActivity {



    Button login;
    EditText userName,password;

    TextView ForgetPassword, Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);


        SessionUtil.setSingout(this);


        login = findViewById(R.id.buttonStudentLogin);
        ForgetPassword=findViewById(R.id.buttonForgetPassword);
        Signup=findViewById(R.id.buttonStudentSignup);

        password = findViewById(R.id.Password);
        userName = findViewById(R.id.UserName);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                }
                else {
                    loginUser();

                    //Session setting
                    if((UserSessionManager.IsLogin).equalsIgnoreCase("login"))
                    {

                        Intent i = new Intent(getApplicationContext(), StudentHomes.class);

                        i.putExtra("StudentUserName", userName.getText().toString());


                        startActivity(i);
                        finish();
                    }

                }

            }
        });

        ForgetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        Signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this,StudentSignupActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loginUser() {
        String UserName = userName.getText().toString();
        String Password = password.getText().toString();

        String method = "login_user";
        BackgroundUserManagement userManagement = new BackgroundUserManagement(this);
        userManagement.execute(method,UserName,Password,"Student");
    }

}