package com.example.pc.custadvisroyapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
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

public class Advisor_AllStudents extends AppCompatActivity {

    String urladdress=APIURL.BASE_URL+"Advisor_AllStudents.php";
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
        setContentView(R.layout.activity_advisor__all_students);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarAdvisor);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Advisor");
        DrawerAdvisor.getDrawer(this,toolBar);

        listView=(ListView)findViewById(R.id.AdvisorAllStudentsList);


        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectAdvisorAllStudentsData();
        CustomAdvisorAllStudentsListView customListView=new CustomAdvisorAllStudentsListView(this, regNo, name, phone, cgpa, chr);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,
                                     int position, long id)
            {
                //        Toast.makeText(HeadAdvisorUnApproveAdvisors.this, "You Clicked at " + Name[+ position], Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), AdvisorStudentDetails.class);
                i.putExtra("RegNo", regNo[+ position]);
                if(regNo[+ position].equalsIgnoreCase(" "))
                {
                    Toast.makeText(Advisor_AllStudents.this, "No result", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(i);
                }
            }
        });


    }
   /* public View getView(int position, View convertView, ViewGroup parent) {
        //View view = super.getView(position, convertView, parent);
        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.BLUE);
        } else {
            convertView.setBackgroundColor(Color.CYAN);
        }

        return convertView;
    }
*/
  //  String username=SessionUtil.getSessionName(this);   //get Advisor Name

    String username=DrawerAdvisor.UserName;

    private void collectAdvisorAllStudentsData()
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
