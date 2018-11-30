package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class StudentHome extends AppCompatActivity {


    // User Session Manager Class
    UserSessionManager session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarStudent);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Student");
        DrawerStudent.getDrawer(this,toolBar);
      /*
        Intent i=getIntent();
        String User = i.getStringExtra("StudentUserName");
        DrawerStudent.UserName=User;
        SessionUtil.setSession(this, User, "sdfghjkoefrtyuio54532gdfdsfede", 3);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Welcome "+User+" ! ",
                Toast.LENGTH_SHORT);

        toast.show();
*/
    }


    public void Home(View v)
    {
        Intent intent = new Intent(this, StudentHome.class);
        startActivity(intent);
    }
    public void Advisor(View v)
    {
        Intent intent = new Intent(this, StudentAdvisor.class);
        startActivity(intent);
    }
    public void Announcements(View v)
    {
        Intent intent = new Intent(this, StudentAnnouncements.class);
        startActivity(intent);
    }
    public void Logout(View v)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        UserSessionManager.IsLogin="";
        startActivity(intent);
    }
}
