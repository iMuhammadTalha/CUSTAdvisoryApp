package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

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

public class AdvisorStudentDetails extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"StudentDetails.php";
    BufferedInputStream is;

    String line=null;
    String result=null;

    String reg;

    TextView regNo, name, email, address, phone, ug_atmp, ug_ernd, curr_sch, prev_sch, u_gpa, u_cgpa;

    String[] RegNo, Name, Email, Address, Phone, Ug_atmp, Ug_ernd, Curr_sch, Prev_sch, U_gpa, U_cgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_student_details);

        regNo= (TextView) findViewById(R.id.tvRegNo);
        name= (TextView) findViewById(R.id.tvName);
        address= (TextView) findViewById(R.id.tvAddress);
        phone= (TextView) findViewById(R.id.tvPhone);
        ug_atmp= (TextView) findViewById(R.id.tvUg_atmp);
        ug_ernd= (TextView) findViewById(R.id.tvUg_ernd);
        curr_sch= (TextView) findViewById(R.id.tvCurr_sch);
        prev_sch= (TextView) findViewById(R.id.tvPrev_sch);
        u_gpa= (TextView) findViewById(R.id.tvU_gpa);
        u_cgpa= (TextView) findViewById(R.id.tvU_cgpa);
        email= (TextView) findViewById(R.id.tvEmail);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Advisor");
        DrawerAdvisor.getDrawer(this,toolBar);

        Intent i=getIntent();
   //     RegNo[0] = i.getStringExtra("RegNo");
         reg= i.getStringExtra("RegNo");

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectStudentDetailsData();




        regNo.setText(reg);
        name.setText(Name[0]);
        address.setText(Address[0]);
        phone.setText(Phone[0]);
        ug_atmp.setText(Ug_atmp[0]);
        ug_ernd.setText(Ug_ernd[0]);
        curr_sch.setText(Curr_sch[0]);
        prev_sch.setText(Prev_sch[0]);
        u_gpa.setText(U_gpa[0]);
        u_cgpa.setText(U_cgpa[0]);
        email.setText(Email[0]);



    }



    private void collectStudentDetailsData()
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
            data = URLEncoder.encode("RegNo","UTF-8")+"="+URLEncoder.encode(reg,"UTF-8");
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
                RegNo=new String[1];
                Name=new String[1];
                Address=new String[1];
                Phone=new String[1];
                Ug_atmp=new String[1];
                Ug_ernd=new String[1];
                Curr_sch=new String[1];
                Prev_sch=new String[1];
                U_gpa=new String[1];
                U_cgpa=new String[1];
                Email=new String[1];

                RegNo[0]=" ";
                Name[0]=" ";
                Address[0]=" ";
                Phone[0]=" ";
                Ug_atmp[0]=" ";
                Ug_ernd[0]=" ";
                Curr_sch[0]=" ";
                Prev_sch[0]=" ";
                U_gpa[0]=" ";
                U_cgpa[0]=" ";
                Email[0]=" ";

            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;

                RegNo= new String[ja.length()];
                Name=new String[ja.length()];
                Address= new String[ja.length()];
                Phone= new String[ja.length()];
                Ug_atmp= new String[ja.length()];
                Ug_ernd= new String[ja.length()];
                Curr_sch= new String[ja.length()];
                Prev_sch= new String[ja.length()];
                U_gpa= new String[ja.length()];
                U_cgpa= new String[ja.length()];
                Email= new String[ja.length()];


                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);

                    RegNo[i] = jo.getString("RegNo");
                    Name[i] = jo.getString("Name");
                    Address[i] = jo.getString("Address");
                    Phone[i] = jo.getString("Phone");
                    Ug_atmp[i] = jo.getString("UG_Atmp");
                    Ug_ernd[i] = jo.getString("UG_Ernd");
                    Curr_sch[i] = jo.getString("Curr_SCH");
                    Prev_sch[i] = jo.getString("Prev_SCH");
                    U_gpa[i] = jo.getString("U_GPA");
                    U_cgpa[i] = jo.getString("U_CGPA");
              //      Email[i] = jo.getString("email");

                    Email[i]=" ";

                }
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }



}
