package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button HeadAdvisor, Student, Advisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Student = findViewById(R.id.buttonStudent);
        HeadAdvisor = findViewById(R.id.buttonHeadAdvisor);

        Advisor = findViewById(R.id.buttonAdvisor);


        Student.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this,StudentLoginActivity.class);
                startActivity(intent);

            }
        });

        HeadAdvisor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,HeadAdvisorLoginActivity.class);
                startActivity(intent);
            }
        });

        Advisor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AdvisorLoginActivity.class);
                startActivity(intent);
            }
        });

    }

}
