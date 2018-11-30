package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class HeadAdvisorAdvisorDetails extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"HeadAdvisor_DeleteAllocatedStudents.php";
    BufferedInputStream is;


    TextView advisor;
    TextView first, last;
    Button delete;
    String First, Last;

    String advisorname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_advisor_advisor_details);

        advisor= (TextView) findViewById(R.id.tvAdvisorName);
        first= (TextView) findViewById(R.id.tvFirstRegNo);
        last= (TextView) findViewById(R.id.tvLastRegNo);

        delete= (Button) findViewById(R.id.delete);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHeadAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("HeadAdvisor");
        DrawerHeadAdvisor.getDrawer(this,toolBar);

        Intent i=getIntent();
        advisorname = i.getStringExtra("AdvisorName");
        First = i.getStringExtra("First");
        Last = i.getStringExtra("Last");

        advisor.setText(advisorname);
        first.setText(First);
        last.setText(Last);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (first.getText().toString().isEmpty() || last.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    First=first.getText().toString();
                    Last=last.getText().toString();

                    deleteStudentAllocationData();
                }
            }
        });

    }

    private void deleteStudentAllocationData() {
//Connection

        try {
            String data = null;

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            data = URLEncoder.encode("advisor_name", "UTF-8") + "=" + URLEncoder.encode(advisorname, "UTF-8")+"&"+
                    URLEncoder.encode("first", "UTF-8") + "=" + URLEncoder.encode(First, "UTF-8")+"&"+
                    URLEncoder.encode("last","UTF-8")+"="+URLEncoder.encode(Last,"UTF-8");
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
                        "Advisor Student Allocation Deleted !",
                        Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), HeadAdvisorAllAdvisors.class);
                startActivity(intent);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

}
