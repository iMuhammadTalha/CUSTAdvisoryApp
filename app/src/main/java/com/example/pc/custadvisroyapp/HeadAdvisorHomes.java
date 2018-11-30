package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class HeadAdvisorHomes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_homes);
    /*
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);
*/
        Intent i=getIntent();
        String User = i.getStringExtra("HeadAdvisorUserName");

        SessionUtil.setSession(this, User, "sdfghjkoertyuio54532gdfdsfede", 1);

        DrawerHeadAdvisor.UserNames=User;

        Toast toast = Toast.makeText(getApplicationContext(),
                "Welcome "+User+" ! ",
                Toast.LENGTH_SHORT);

        toast.show();

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);
    }


    public void AllStudents(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorAllStudents.class);
        startActivity(intent);
    }
    public void CSStudents(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorCSStudents.class);
        startActivity(intent);
    }
    public void SEStudents(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorSEStudents.class);
        startActivity(intent);
    }

    public void AllAdvisors(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorAllAdvisors.class);
        startActivity(intent);
    }
    public void CSAdvisors(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorCSAdvisors.class);
        startActivity(intent);
    }
    public void SEAdvisors(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorSEAdvisors.class);
        startActivity(intent);
    }

    public void UnApproveAdvisor(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorUnApproveAdvisors.class);
        startActivity(intent);
    }
    public void Announcements(View v)
    {
        Intent intent = new Intent(this, HeadAdvisorAnnouncements.class);
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
