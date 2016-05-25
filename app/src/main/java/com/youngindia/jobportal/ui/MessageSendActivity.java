package com.youngindia.jobportal.ui;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.youngindia.jobportal.R;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;



public class MessageSendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button button=(Button)findViewById(R.id.button1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        try {
            /*String username = "jobportal";
            String password = "jp8956";*/
            String phoneno="8553032489";
          /*  String sms_attd="user_pwd";*/
            String name="admin";
            String pass="password";
            String username = "yiisdemo";
            String password = "yiisdemo1236";

            String stud_attd="stud_attd";
            String link="http://www.youngindiagroup.in/";
           /* String requestUrl  = "http://websms.way2mint.com/index.php/web_service/sendSMS?" +
                    "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8") +
                    "&destination=" + URLEncoder.encode(phoneno, "UTF-8") +
                    "&template_name=" + URLEncoder.encode(sms_attd, "UTF-8") +
                    "&templateParameters[A]=" + URLEncoder.encode(name, "UTF-8") +
                    "&templateParameters[B]=" + URLEncoder.encode(pass, "UTF-8") +
                    "&templateParameters[C]=" + URLEncoder.encode(link, "UTF-8") +
                    "&responseformat=json"+
                    "&sender_id=YoungIndia" ;*/
            String requestUrl  = "http://websms.way2mint.com/index.php/web_service/sendSMS?" +
                    "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8") +
                    "&destination=" + URLEncoder.encode(phoneno, "UTF-8") +
                    "&template_name=" + URLEncoder.encode(stud_attd, "UTF-8") +
                    "&templateParameters[A]=" + URLEncoder.encode(name, "UTF-8") +
                    "&templateParameters[B]=" + URLEncoder.encode(pass, "UTF-8") +
                    "&templateParameters[C]=" + URLEncoder.encode( pass, "UTF-8") +
                    "&templateParameters[D]=" + URLEncoder.encode(name, "UTF-8") +
                    "&responseformat=json"+
                    "&sender_id=SCHOOL" ;

            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection)url.openConnection();
            JSONArray response = new JSONArray();
            int responseCode = uc.getResponseCode();
            //	Toast.makeText(getActivity().getApplicationContext(), "Message Send sucessfully", Toast.LENGTH_SHORT).show();
           /* if(responseCode == HttpStatus.SC_OK){
                String responseString = readStream(uc.getInputStream());
                Log.v("CatalogClient", responseString);*/
              /*  response = new JSONArray(responseString);
            }else{
                Log.e("CatalogClient", "Response code:"+ responseCode);
            }*/


            Log.e("tag", "msg,,,,,,,,,,,,,,,,,,,," + requestUrl);
            uc.disconnect();

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            }
        });
    }
}
