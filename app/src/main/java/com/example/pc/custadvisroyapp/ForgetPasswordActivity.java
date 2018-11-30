package com.example.pc.custadvisroyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText email;
    Button SendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        SendEmail = findViewById(R.id.buttonSendEmail);
        email = findViewById(R.id.Email);


        SendEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else {
                    forgetPassword();
                }

            }
        });
    }

    private void forgetPassword() {
        String Email = email.getText().toString();

        String method = "forgetPassword_user";
        BackgroundUserManagement userManagement = new BackgroundUserManagement(this);
        userManagement.execute(method,Email);
    }

}
