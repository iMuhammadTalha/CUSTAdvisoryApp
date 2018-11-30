package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class AdvisorHomes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_homes);
    /*
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Advisor");
        DrawerAdvisor.getDrawer(this,toolBar);
*/
        Intent i=getIntent();
        String User = i.getStringExtra("AdvisorUserName");
       /* if(User.equalsIgnoreCase(""))
        {
            User=DrawerAdvisor.UserName;
        }
        else {
            DrawerAdvisor.UserName = User;


            Toast toast = Toast.makeText(getApplicationContext(),
                    "Welcome "+User+" ! ",
                    Toast.LENGTH_SHORT);

            toast.show();

        }
        */
        DrawerAdvisor.UserName = User;

        Toast toast = Toast.makeText(getApplicationContext(),
                "Welcome "+User+" ! ",
                Toast.LENGTH_SHORT);

        toast.show();
        SessionUtil.setSession(this, User, "sdfghjkoertyuio54g532gdfdsfede", 2);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Advisor");
        DrawerAdvisor.getDrawer(this,toolBar);
    }

    public void Students(View v)
    {
        Intent intent = new Intent(this, Advisor_AllStudents.class);
        startActivity(intent);
    }
    public void StudentAnnouncements(View v)
    {
        Intent intent = new Intent(this, AdvisorStudentAnnouncements.class);
        startActivity(intent);
    }
    public void HeadAdvisorAnnouncements(View v)
    {
        Intent intent = new Intent(this, AdvisorHeadAdvisorAnnouncements.class);
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
