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

public class HeadAdvisorUnApproveAdvisors extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"headAdvisor_UnApproveAdvisors.php";
    String[] Name;
    String[] Designation;
    String[] Department;
    String[] Phone;
    String[] Email;

    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_un_approve_advisors);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("HeadAdvisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        listView=(ListView)findViewById(R.id.HeadAdvisorUnApproveList);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));



        collectUnApproveAdvisorsData();

        CustomUnApproveAdvisorsListView customListView=new CustomUnApproveAdvisorsListView(this, Name, Designation, Department, Phone, Email);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,
                                     int position, long id)
            {
                //        Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "You Clicked at " + Name[+ position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), HeadAdvisorApproveAdvisor.class);
                i.putExtra("AdvisorName", Name[+ position]);
                if(Name[+ position].equalsIgnoreCase(" "))
                {
                    Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "No result", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(i);
                }
            }
        });

    }
    private void collectUnApproveAdvisorsData()
    {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try {

            boolean check=result.contains("null");
            if(check==true)                  //For Empty Result
            {
                Name=new String[1];
                Designation=new String[1];
                Department=new String[1];
                Phone=new String[1];
                Email=new String[1];

                Name[0]=" ";
                Designation[0]=" No Result";
                Department[0]=" ";
                Phone[0]=" ";
                Email[0]=" ";
            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;



                Name = new String[ja.length()];
                Designation = new String[ja.length()];
                Department = new String[ja.length()];
                Phone = new String[ja.length()];
                Email = new String[ja.length()];


                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    Name[i] = jo.getString("Name");
                    Designation[i] = jo.getString("Designation");
                    Department[i] = jo.getString("Department");
                    Phone[i] = jo.getString("Phone");
                    Email[i] = jo.getString("Email");
                }

            }

        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

}
