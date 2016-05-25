package com.youngindia.jobportal.ui.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.youngindia.jobportal.R;
import com.youngindia.jobportal.adapter.ListAdapter;

import java.sql.Array;

public class Search_list_Activity extends AppCompatActivity {

    ListAdapter listAdapter;

    public String[]job_name={"Plamber", "Tailor", "Barber", "Cobbler", "Hair Stylist", "Designer"};
    public String[]job_wages={"Rs.1000", "Rs. 2000", "Rs. 3000", "Rs 4000","Rs.5000", "Rs.6000"};
    public String[]job_hr={"1 hr","2 hr","3 hr","4 hr","5 hr","6 hr","7 hr","8 hr"};

    ListView listView_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView_search= (ListView) findViewById(R.id.listView_serachitems);
        listAdapter=new ListAdapter(this,job_name,job_wages,job_hr);
        listView_search.setAdapter(listAdapter);





    }

}
