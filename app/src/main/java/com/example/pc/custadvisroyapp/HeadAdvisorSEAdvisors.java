package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HeadAdvisorSEAdvisors extends AppCompatActivity {

    String urladdress = APIURL.BASE_URL + "headAdvisor_SEAdvisors.php";
    private String[] AdvisorName;
    private String[] NoOfStudents;
    private String[] FirstStudent;
    private String[] LastStudent;
    ListView listView;
    BufferedInputStream is;
    String line = null;
    String result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_seadvisors);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this, toolBar);

        listView = (ListView) findViewById(R.id.SEAdvisorsList);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectSEAdvisorsData();
        CustomSEAdvisorListView customListView = new CustomSEAdvisorListView(this, AdvisorName, NoOfStudents, FirstStudent, LastStudent);
        listView.setAdapter(customListView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,
                                     int position, long id)
            {
                //        Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "You Clicked at " + Name[+ position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), HeadAdvisorAdvisorDetails.class);
                i.putExtra("AdvisorName", AdvisorName[+ position]);
                i.putExtra("First", FirstStudent[+ position]);
                i.putExtra("Last", LastStudent[+ position]);

                if(AdvisorName[+ position].equalsIgnoreCase(" "))
                {
                    Toast.makeText(HeadAdvisorSEAdvisors.this, "No result", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(i);
                }
            }
        });



    }


    private void collectSEAdvisorsData() {
//Connection
        try {

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //content
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

//JSON
        try {

            boolean check=result.contains("null");
            if(check==true)                  //For Empty Result
            {
                AdvisorName=new String[1];
                NoOfStudents=new String[1];
                FirstStudent=new String[1];
                LastStudent=new String[1];

                AdvisorName[0]=" ";
                NoOfStudents[0]=" No Result";
                FirstStudent[0]=" ";
                LastStudent[0]=" ";
            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;
                AdvisorName = new String[ja.length()];
                NoOfStudents = new String[ja.length()];
                FirstStudent = new String[ja.length()];
                LastStudent = new String[ja.length()];


                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    AdvisorName[i] = jo.getString("Name");
                    NoOfStudents[i] = jo.getString("No_of_students");
                    FirstStudent[i] = jo.getString("First_student");
                    LastStudent[i] = jo.getString("Last_student");

                }
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }
}