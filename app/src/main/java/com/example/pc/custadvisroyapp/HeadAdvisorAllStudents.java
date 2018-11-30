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

public class HeadAdvisorAllStudents extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"headAdvisor_AllStudents.php";
    String[] regNo;
    String[] name;
    String[] phone;
    String[] cgpa;
    String[] chr;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_all_students);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        listView=(ListView)findViewById(R.id.AllStudentsList);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectAllStudentsData();
        CustomAllStudentsListView customListView=new CustomAllStudentsListView(this, regNo, name, phone, cgpa, chr);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,
                                     int position, long id)
            {
                //        Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "You Clicked at " + Name[+ position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), HeadAdvisorStudentDetails.class);
                i.putExtra("RegNo", regNo[+ position]);
                if(regNo[+ position].equalsIgnoreCase(" "))
                {
                    Toast.makeText(HeadAdvisorAllStudents.this, "No result", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(i);
                }
            }
        });


    }



    private void collectAllStudentsData()
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
        try{

            boolean check=result.contains("null");
            if(check==true)                  //For Empty Result
            {
                regNo=new String[1];
                name=new String[1];
                phone=new String[1];
                cgpa=new String[1];
                chr=new String[1];

                regNo[0]=" ";
                name[0]=" No Result";
                phone[0]=" ";
                cgpa[0]=" ";
                chr[0]=" ";
            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;
                regNo = new String[ja.length()];
                name = new String[ja.length()];
                phone = new String[ja.length()];
                cgpa = new String[ja.length()];
                chr = new String[ja.length()];

                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    regNo[i] = jo.getString("RegNo");
                    name[i] = jo.getString("Name");
                    phone[i] = jo.getString("Phone");
                    cgpa[i] = jo.getString("U_CGPA");
                    chr[i] = jo.getString("UG_Ernd");
                }
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

}
