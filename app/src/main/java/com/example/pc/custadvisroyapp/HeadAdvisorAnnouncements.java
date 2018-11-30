
package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HeadAdvisorAnnouncements extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"HeadAdvisor_Announcement.php";

    BufferedInputStream is;
    EditText title,description;
    Button btnAdded,allannouncements;

    String Titles, Descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_announcements);

        title=(EditText) findViewById(R.id.etTitle);
        description=(EditText) findViewById(R.id.etDescription);
        btnAdded = (Button) findViewById(R.id.btnAddAnnouncement);
        allannouncements = (Button) findViewById(R.id.btnPreviousAnnouncments);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));


        btnAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (title.getText().toString().isEmpty() || description.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Titles=title.getText().toString();
                    Descriptions=description.getText().toString();

                    addStudentAnnouncementsData();
                }
            }
        });

        allannouncements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HeadAdvisorPreviousAnnoucements.class);
                startActivity(intent);

            }
        });


    }

    private void addStudentAnnouncementsData() {
//Connection

        String username=DrawerHeadAdvisor.UserNames;


        try {
            String data = null;

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8")+"&"+
                    URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(Titles, "UTF-8")+"&"+
                    URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(Descriptions,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            os.close();

            is = new BufferedInputStream(con.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String line = " ";
            while ((line = bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            if((stringBuilder.toString()).equalsIgnoreCase("Added"))
            {
                title.setText("");
                description.setText("");

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Announcement Added !",
                        Toast.LENGTH_SHORT);

                toast.show();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
