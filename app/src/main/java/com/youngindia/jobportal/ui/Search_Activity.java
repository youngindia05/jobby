package com.youngindia.jobportal.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.Model_Search;
import com.youngindia.jobportal.ui.app.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {
    private EditText editTextId;
    private Button buttonGet;
    private Spinner location,qualification,experience,salary;
    private EditText autoCompleteTextView;
    private TextView textViewResult;

    private ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        toolbar.setNavigationIcon(R.drawable.toolbar_backbtn);
        setSupportActionBar(toolbar);

        autoCompleteTextView= (EditText) findViewById(R.id.autocompleteEditTextView);
        qualification=(Spinner)findViewById(R.id.qualification);
        location=(Spinner)findViewById(R.id.location);

        salary=(Spinner)findViewById(R.id.salary);


        buttonGet = (Button) findViewById(R.id.btnSubmit);
      //  textViewResult = (TextView) findViewById(R.id.textViewResult);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!autoCompleteTextView.getText().toString().isEmpty() || !qualification.getSelectedItem().toString().isEmpty() || !location.getSelectedItem().toString().isEmpty())

                {
                    //getData();
                    Intent intent =new Intent(Search_Activity.this,Search_Result.class);
                    intent.putExtra("Keyword",autoCompleteTextView.getText().toString().trim());
                    intent.putExtra("Qualification",qualification.getSelectedItem().toString().trim());
                    intent.putExtra("Location",location.getSelectedItem().toString().trim());
                    intent.putExtra("Salary",salary.getSelectedItem().toString().trim());
                    startActivity(intent);
                } else {
Toast.makeText(getApplicationContext(),"please enter the value",Toast.LENGTH_SHORT).show();
                }
            }});
    }

    private void getData() {
        //String id = editTextId.getText().toString().trim();

      /*  if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }*/

        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);
        String url = AppConfig.DATA_URL+"keyword="+autoCompleteTextView.getText().toString().trim()
                +"&qualification="+qualification.getSelectedItem().toString().trim()
                +"&location="+location.getSelectedItem().toString().trim()
                +"&salary="+salary.getSelectedItem().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Search_Activity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String response){
        String technology="";
        String companyname="";
        String position="";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(AppConfig.JSON_ARRAY);
            StringBuilder sb =new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            StringBuilder sb3=new StringBuilder();
            for(int n = 0; n < result.length(); n++) {
                JSONObject searchData = result.getJSONObject(n);
                // technology = searchData.getString(AppConfig.KEY_TECHNOLOGY);
                //array.add(0,searchData.getString(AppConfig.KEY_TECHNOLOGY));
                sb.append(searchData.getString(AppConfig.KEY_TECHNOLOGY));
                sb2.append(searchData.getString(AppConfig.KEY_COMPANY));
                sb3.append(searchData.getString(AppConfig.KEY_POSITION));
//                companyname = searchData.getString(AppConfig.KEY_COMPANY);
//                position=searchData.getString(AppConfig.KEY_POSITION);
            }
            technology=sb.toString();
            companyname=sb2.toString();
            position=sb3.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //textViewResult.setText("technology:\t" + technology + "\ncompanyname:\t" + companyname + "\nposition:\t" +position);
    }

}
