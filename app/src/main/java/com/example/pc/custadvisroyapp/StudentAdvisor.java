package com.example.pc.custadvisroyapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
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

public class StudentAdvisor extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"student_Advisor.php";
    String[] name;
    String[] email;
    String[] phone;
    String[] designation;
    String[] department;

//    ListView listView;

    TextView Name, Email, Phone, Designation, Department;

    BufferedInputStream is;
    String line=null;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_advisor);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarStudent);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Student");
        DrawerStudent.getDrawer(this,toolBar);


        Name=(TextView) findViewById(R.id.tvAdvisorName) ;
        Email=(TextView) findViewById(R.id.tvAdvisorEmail) ;
        Phone=(TextView) findViewById(R.id.tvAdvisorPhone) ;
        Designation=(TextView) findViewById(R.id.tvAdvisorDesignation) ;
        Department=(TextView) findViewById(R.id.tvAdvisorDepartment) ;


        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectStudentAdvisorData();


        Name.setText(name[0]);
        Email.setText(email[0]);
        Phone.setText(phone[0]);
        Designation.setText(designation[0]);
        Department.setText(department[0]);


    }

    //  String username=SessionUtil.getSessionName(this);   //get Advisor Name

    String username=DrawerStudent.UserName;

    private void collectStudentAdvisorData()
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
                name=new String[1];
                email=new String[1];
                phone=new String[1];
                designation=new String[1];
                department=new String[1];

                name[0]=" No Result";
                email[0]=" ";
                phone[0]=" ";
                designation[0]=" ";
                department[0]=" ";

            }
            else {

                JSONArray ja = new JSONArray(result);
                JSONObject jo = null;
                name = new String[ja.length()];
                email = new String[ja.length()];
                phone = new String[ja.length()];
                designation = new String[ja.length()];
                department = new String[ja.length()];

                for (int i = 0; i <= ja.length(); i++) {
                    jo = ja.getJSONObject(i);
                    name[i] = jo.getString("Name");
                    email[i] = jo.getString("Email");
                    phone[i] = jo.getString("Phone");
                    designation[i] = jo.getString("Designation");
                    department[i] = jo.getString("Department");
                }
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

}
