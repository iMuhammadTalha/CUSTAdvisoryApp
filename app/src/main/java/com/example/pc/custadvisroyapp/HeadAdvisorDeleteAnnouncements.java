package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class HeadAdvisorDeleteAnnouncements extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"DeleteAnnouncements.php";
    BufferedInputStream is;



    TextView title, description;
    Button delete;
    String Title, Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_delete_announcements);

        title= (TextView) findViewById(R.id.tvTitle);
        description= (TextView) findViewById(R.id.tvDescription);

        delete= (Button) findViewById(R.id.delete);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Head Advisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        Intent i=getIntent();
        Title = i.getStringExtra("Title");
        Description = i.getStringExtra("Description");

        title.setText(Title);
        description.setText(Description);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (title.getText().toString().isEmpty() || description.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Title=title.getText().toString();
                    Description=description.getText().toString();

                    deleteAnnouncementData();
                }
            }
        });

    }


    private void deleteAnnouncementData() {
//Connection

        try {
            String data = null;

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(Title, "UTF-8")+"&"+
                    URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(Description, "UTF-8");
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
            if((stringBuilder.toString()).equalsIgnoreCase("Deleted"))
            {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Announcement Deleted !",
                        Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), AdvisorStudentPreviousAnnouncements.class);
                startActivity(intent);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }


}
