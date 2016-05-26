package com.youngindia.jobportal.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;
import com.youngindia.jobportal.adapter.Model_Search;
import com.youngindia.jobportal.adapter.Search_Adapter;
import com.youngindia.jobportal.ui.app.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Search_Result extends AppCompatActivity {
    Search_Activity search_activity;
    private ProgressDialog loading,pd;
    String keyword,Qualification,location,salary;
    Search_Adapter adapter;
    ListView search_list;
    Context context;

    public static ArrayList<Model_Search> searchlist = new ArrayList<Model_Search>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context=this;
        search_list=(ListView)findViewById(R.id.listView2);
        Intent myIntent = getIntent(); // gets the previously created intent
        keyword=(myIntent.getStringExtra("Keyword"));
        Qualification=( myIntent.getStringExtra("Qualification"));
        location=( myIntent.getStringExtra("Location"));;
        salary=(myIntent.getStringExtra("Salary"));
//        BackTask bt=new BackTask();
//        bt.execute();
        adapter=new Search_Adapter(this,R.layout.customsearch_layout,searchlist);
        search_list.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        BackTask bt=new BackTask();
        bt.execute();

    }

    public void showJSON(String response){

        try {
            ArrayList<Model_Search> searchlist1 = new ArrayList<Model_Search>();
            searchlist1 = null;
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(AppConfig.JSON_ARRAY);
            for(int n = 0; n < result.length(); n++) {
                JSONObject searchData = result.getJSONObject(n);
                Model_Search p=new Model_Search( searchData.getString(AppConfig.KEY_TECHNOLOGY),
                        searchData.getString(AppConfig.KEY_COMPANY),
                        searchData.getString(AppConfig.KEY_POSITION));
                searchlist1.add(p);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    private class BackTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {

            String url = AppConfig.DATA_URL+"keyword="+keyword
                    +"&qualification="+Qualification
                    +"&location="+location
                    +"&salary="+salary;
            StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray result = jsonObject.getJSONArray(AppConfig.JSON_ARRAY);
                        for (int n = 0; n < result.length(); n++) {
                            JSONObject searchData = result.getJSONObject(n);
                            Model_Search p = new Model_Search(searchData.getString(AppConfig.KEY_TECHNOLOGY),
                                    searchData.getString(AppConfig.KEY_COMPANY),
                                    searchData.getString(AppConfig.KEY_POSITION));
                            searchlist.add(p);
                        }



                    } catch (JSONException e) {  e.printStackTrace();  }
                    // adapter.notifyDataSetChanged();
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    });


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(context);

            pd.setTitle("Retrieving data");

            pd.setMessage("Please wait.");

            pd.setCancelable(true);

            pd.setIndeterminate(true);

            pd.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(pd!=null) pd.dismiss(); //close dialog

            Log.e("size", searchlist.size() + "");

            adapter.notifyDataSetChanged();
        }
    }
}
