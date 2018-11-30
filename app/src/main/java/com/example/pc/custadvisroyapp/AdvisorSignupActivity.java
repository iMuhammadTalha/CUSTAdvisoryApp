package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AdvisorSignupActivity extends AppCompatActivity {

    RadioGroup genderGroup;
    RadioButton Gender;

    EditText username, email, password, repassword, phone, department, designation;
    Button signupAdvisor;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_signup);

        login = findViewById(R.id.btnLogin);

        signupAdvisor=findViewById(R.id.buttonSignup);

        signupAdvisor=findViewById(R.id.buttonSignup);

        password = findViewById(R.id.Password);
        username = findViewById(R.id.UserName);
        repassword=findViewById(R.id.RePassword);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.Phone);
        department=findViewById(R.id.Department);
        designation=findViewById(R.id.Designation);

        genderGroup=findViewById(R.id.RadioGender);
        int radioId = genderGroup.getCheckedRadioButtonId();
        Gender = findViewById(radioId);
        Gender.getText();


        signupAdvisor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()|| repassword.getText().toString().isEmpty()|| email.getText().toString().isEmpty()|| department.getText().toString().isEmpty()|| designation.getText().toString().isEmpty() || phone.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else if(repassword.getText().toString().matches(password.getText().toString()))
                {
                    signupAdvisor();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Password not matched",Toast.LENGTH_LONG).show();
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdvisorSignupActivity.this,AdvisorLoginActivity.class);
                startActivity(intent);

            }
        });


    }


    private void signupAdvisor() {
        String UserName = username.getText().toString();
        String Password = password.getText().toString();
        String Email= email.getText().toString();
        String genders= Gender.getText().toString();
        String Phone=phone.getText().toString();
        String Designation=designation.getText().toString();
        String Department=department.getText().toString();

        String method = "signup_advisor";
        BackgroundUserManagement userManagement = new BackgroundUserManagement(this);
        userManagement.execute(method,UserName,Password,Email,genders,Phone,Department,Designation);
    }

}
