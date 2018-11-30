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
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HeadAdvisorPreviousAnnoucements extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"HeadAdvisor_PreviousAnnouncements.php";
    String[] date;
    String[] title;
    String[] description;

    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_previous_annoucements);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        listView=(ListView)findViewById(R.id.HeadAdvisorPreviousAnnouncementsList);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectAdvisorPreviousAnnouncementsData();
        CustomHeadAdvisorAnnouncementsListView customListView=new CustomHeadAdvisorAnnouncementsListView(this, date, title, description);
        listView.setAdapter(customListView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,
                                     int position, long id)
            {
                //        Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "You Clicked at " + Name[+ position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), HeadAdvisorDeleteAnnouncements.class);
                i.putExtra("Title", title[+ position]);
                i.putExtra("Description", description[+ position]);
                if(title[+ position].equalsIgnoreCase(" ")||description[+ position].equalsIgnoreCase(" "))
                {
                    Toast.makeText(HeadAdvisorPreviousAnnoucements.this, "No result", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(i);
                }
            }
        });


    }

    //  String username=SessionUtil.getSessionName(this);   //get Advisor Name

    String username=DrawerHeadAdvisor.UserNames;

    private void collectAdvisorPreviousAnnouncementsData()
    {
//Connection
        try{
            String data = null;

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            os.close();


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
                date=new String[1];
                title=new String[1];
                description=new String[1];


                date[0]=" ";
                title[0]=" ";
                description[0]="No Result ";

            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;
                date = new String[ja.length()];
                title = new String[ja.length()];
                description = new String[ja.length()];


                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    date[i] = jo.getString("Date");
                    title[i] = jo.getString("Title");
                    description[i] = jo.getString("Description");

                }
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }
}
