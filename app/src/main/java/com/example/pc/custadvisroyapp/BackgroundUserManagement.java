package com.example.pc.custadvisroyapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundUserManagement extends AsyncTask<String,Void,String> {

    private Context ctx;

    BackgroundUserManagement(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("Query"," "+s);
        Toast.makeText(ctx,s,Toast.LENGTH_LONG).show();
    }


    @Override
    protected String doInBackground(String... prims) {

        final String Login_URL = APIURL.BASE_URL+"userManagement_login.php";            //Base URL for use API
        final String ForgetPassword_URL = APIURL.BASE_URL+"userManagement_ForgetPassword.php";
        final String SignupStudent_URL = APIURL.BASE_URL+"userManagement_StudentSignup.php";
        final String SignupAdvisor_URL = APIURL.BASE_URL+"userManagement_AdvisorSignup.php";

        String method_receive = prims[0];
        String data = null;
        if (method_receive.equals("login_user")) {
            String userName = prims[1];
            String password = prims[2];
            String role = prims[3];

            try {
                URL url = new URL(Login_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(userName,"UTF-8")+"&"+
                        URLEncoder.encode("user_password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("user_role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = " ";
                while ((line = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line);
                }
                bufferedReader.close();

                if((stringBuilder.toString()).equalsIgnoreCase("Login"))
                {
                    UserSessionManager.IsLogin="login";
                }
                else
                {
                    UserSessionManager.IsLogin="";
                }

                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method_receive.equals("forgetPassword_user")) {
            String email = prims[1];

            try {
                URL url = new URL(ForgetPassword_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                data = URLEncoder.encode("user_email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = " ";
                while ((line = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method_receive.equals("signup_student")) {
            String regNo = prims[1];
            String email = prims[3];
            String password = prims[2];

            try {
                URL url = new URL(SignupStudent_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                data = URLEncoder.encode("student_regNo","UTF-8")+"="+URLEncoder.encode(regNo,"UTF-8")+"&"+
                        URLEncoder.encode("student_password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("student_email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = " ";
                while ((line = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method_receive.equals("signup_advisor")) {
            String regNo = prims[1];
            String email = prims[3];
            String password = prims[2];
            String gender = prims[4];
            String phone = prims[5];
            String department = prims[6];
            String designation = prims[7];

            try {
                URL url = new URL(SignupAdvisor_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                data = URLEncoder.encode("advisor_regNo","UTF-8")+"="+URLEncoder.encode(regNo,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_department","UTF-8")+"="+URLEncoder.encode(department,"UTF-8")+"&"+
                        URLEncoder.encode("advisor_desigation","UTF-8")+"="+URLEncoder.encode(designation,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = " ";
                while ((line = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "Success";
    }

}
